package com.digitalimpact21.Globalimpact;

import Diretório.Adicionais;
import Diretório.Produto;
import ProdutoRepository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Properties;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository pr;



    @RequestMapping (value = "/cadastrarProduto", method = RequestMethod.GET)
    public String form() {
        return "Produto/FormProduto";
    }
    @RequestMapping (value = "/cadastrarProduto", method = RequestMethod.POST)
    public String form(Produto produto) {
        pr.save(produto);

        return "Produto/FormProduto";
}
    @RequestMapping("/produtos")
    public ModelAndView listaProdutos() {
        ModelAndView mv = new ModelAndView("index");
        Iterable<Produto> produto = pr.findAll();
        mv.addObject("produto", produto);
        return  mv;
    }

    @RequestMapping(value ="/{codigo}", method = RequestMethod.GET)
    public ModelAndView detalhesProduto(@PathVariable("codigo") long codigo){
        Produto produto = pr. finfByCodigo(codigo);
        ModelAndView mv = new ModelAndView("Produto/detalhesproduto");
        mv.addObject("produto", produto);
        System.out.println("produto" + produto);
        return mv;

    }
    @RequestMapping(value ="/{codigo}", method = RequestMethod.POST)
    public String detalhesProduto(@PathVariable("codigo") long codigo, Adicionais adicionais){
       Produto produto = pr . finfByCodigo(codigo);
       adicionais.setProduto(produto);
        Properties ar = null;
       return "redirect";
    }
}
