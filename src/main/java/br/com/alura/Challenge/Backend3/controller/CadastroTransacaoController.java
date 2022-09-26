package br.com.alura.Challenge.Backend3.controller;

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

    @GetMapping("/form")
    public String formUploadFile(Model model) {
        model.addAttribute("frase", null);
        return "form_upload";
    }

    @PostMapping("/novo")
    public ModelAndView HandleFileUploaded(@RequestParam("file") MultipartFile fileUploaded) {

        if (!fileUploaded.isEmpty()) {
            System.out.println("\n" + fileUploaded.getOriginalFilename() + "; size: " + fileUploaded.getSize() + "\n");

            try {
                this.storageService.storageData(fileUploaded.getInputStream());
                ModelAndView mv = new ModelAndView("form_upload");
                mv.addObject("frase", "Arquivo importado com sucesso !");
                return mv;
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return new ModelAndView("redirect:/transacao/form");
    }

}
