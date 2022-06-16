package sia.tacocloud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import sia.tacocloud.models.Ingredient;
import sia.tacocloud.models.Ingredient.Type;
import sia.tacocloud.models.Taco;
import sia.tacocloud.models.TacoOrder;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller // #1
@RequestMapping("/design") // #2
@SessionAttributes("tacoOrder") // #3
public class DesignTacoController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);

    @ModelAttribute // #5
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder") // #7
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco") // #7
    public Taco taco() {
        return new Taco();
    }

    @GetMapping // #4
    public String showDesignForm() {
        return "design"; // indicates to render the design.html view to user
    }

    @PostMapping // #8
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) { // #9
        if (errors.hasErrors()){
            return "design";
        }
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);

        return "redirect:/orders/current"; // indicates that user should be redirected to /orders/current
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}

// 1: @Controller
/*
    - identifies class as controller and enables component scanning so Spring can automatically create an instance of it
      as a bean in the Spring application context
 */

// 2: @RequestMapping
/*
    - when applied at the class level, specifies the kind of requests the controller handles
    - in this case, specifies that DesignTacoController will handle requests whose path begins with '/design'
 */

// 3: @SessionAttributes("tacoOrder")
/*
    - Indicates that the `TacoOrder` model attribute object (see #6) should be maintained in session so that it can be
      available for multiple requests
 */

// 4: @GetMapping
/*
    - @GetMapping, paired with class-level @RequestMapping, specifies that when an HTTP GET request is received for
      /design, Spring MVC will call showDesignForm() to handle the request
      - In this case, it returns a string "design" when a GET request for '/design' is received
      - Also other methods are invoked, such as #5
 */

// 5: addIngredientsToModel()
/*
    - Method is when a request is handled
    - Constructs a list of `Ingredient` objects to put into `Model` (see #6)
 */

// 6: Model
/*
    - Model is an object that ferries data between controller and whatever view is charged with rendering that data
    - Data placed in Model attributes is copied into the servlet request attributes where the view can find them and use
      them to render a page in the user's browsers
      - view libraries such as thymeleaf can work with servlet request attributes to render it
 */

// 7: @ModelAttribute(name = XXX)
/*
    - creates objects and places them into the model under the specified name in the annotation
 */

// 8: @PostMapping
/*
    - Coordinates with class-level @RequestMapping to indicate method should handle POST requests to /design
    -
 */

// 9: (@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder)
/*
    - form fields from design page gets sent to processTaco and a new taco object is created from it
      - See IngredientByIdConverter class to see how form checkboxes that capture String input, is converted into Ingredients
    - Adds newly created taco from form submission to TacoOrder
    - TacoOrder parameter indicates it should uses the TacoOrder object that was placed into the model earlier via the
      order() method
    - @Valid tells Spring MVC to perform validation on the submitted Taco object after its bound to the submitted form data
      - validation errors will be captured in the Errors object
    - NOTE: there seems to be several ways to go about handling model attributes and model...example shown in the chapter
      is just one way to do it
      - I should refer to Spring official guides or some other resources when thinking about how to handle model and requests
 */