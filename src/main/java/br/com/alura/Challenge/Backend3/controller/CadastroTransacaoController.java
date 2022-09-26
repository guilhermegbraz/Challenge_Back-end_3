package br.com.alura.Challenge.Backend3.controller;

import br.com.alura.Challenge.Backend3.service.dao.DateOfTransactionDAO;
import br.com.alura.Challenge.Backend3.service.dao.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/transacao")
public class CadastroTransacaoController {

    @Autowired
    StorageService storageService;

    @Autowired
    DateOfTransactionDAO dateOfTransactionDAO;

    private String message;

    @GetMapping("/form")
    public String formUploadFile(Model model) {

        model.addAttribute("frase", this.message);
        model.addAttribute("transactions", this.dateOfTransactionDAO.selectAll());
        this.message = null;
        return "form_upload";
    }

    @PostMapping("/novo")
    public ModelAndView HandleFileUploaded(@RequestParam("file") MultipartFile fileUploaded) {

        if (!fileUploaded.isEmpty()) {
            System.out.println("\n" + fileUploaded.getOriginalFilename() + "; size: " + fileUploaded.getSize() + "\n");

            try {
                this.message = this.storageService.storageTransactionData(fileUploaded.getInputStream());

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return new ModelAndView("redirect:/transacao/form");
    }

}
