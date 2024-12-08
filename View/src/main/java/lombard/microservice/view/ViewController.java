package lombard.microservice.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewController {

    private final ViewService viewService;

    @Autowired
    public ViewController(ViewService viewService) {
        this.viewService = viewService;
    }

    /*
    Обработчики главной страницы
    */
    @GetMapping("")
    public String index() {
        return "index";
    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "exception";
    }


    /*
    Обработчики клиентов
    */
    @GetMapping("client-list/")
    public String clientList(Model model) {
        model.addAttribute("clients", viewService.getClientList());
        return "client-list";
    }

    @GetMapping("client-detail/{id}/")
    public String clientDetail(Model model, @PathVariable Long id) {
        model.addAttribute("client", viewService.getClientById(id));
        return "client-detail";
    }


    /*
    Обработчики имущества
    */
    @GetMapping("property-list/")
    public String propertyList(Model model) {
        model.addAttribute("properties", viewService.getPropertyList());
        return "property-list";
    }

    @GetMapping("property-detail/{id}/")
    public String propertyDetail(Model model, @PathVariable Long id) {
        model.addAttribute("property", viewService.getPropertyById(id));
        return "property-detail";
    }


    /*
    Обработчики займов
    */
    @GetMapping("loan-list/")
    public String loanList(Model model) {
        model.addAttribute("loans", viewService.getLoanList());
        return "loan-list";
    }

    @GetMapping("loan-detail/{id}/")
    public String loanDetail(Model model, @PathVariable Long id) {
        model.addAttribute("loan", viewService.getLoanById(id));
        return "loan-detail";
    }
}
