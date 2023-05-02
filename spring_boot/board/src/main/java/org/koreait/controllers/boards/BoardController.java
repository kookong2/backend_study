package org.koreait.controllers.boards;

import jakarta.validation.Valid;
import org.modelmapper.internal.Errors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("FrontBoardController")
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/write/{bId}")
    public String write(@PathVariable String bId, Model model){
        BoardData boardData = new BoardData();
        boardData.setBId(bId);
        model.addAttribute("boardData",boardData);

        String [] addScript = {"fileManager", "ckeditor/ckeditor", "board/form"};
        model.addAttribute("addScript", addScript);

        return "board/write";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id){

        return "board/update";
    }
    @PostMapping("/write/{bId}")
    public String writePs(@Valid BoardData boardData, Errors errors){
        if(errors.hasErrors()){
            return "board/write";
        }

        return "redirect:/board/list/" + boardData.getBId();
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id){

        return "board/view";
    }

    @GetMapping("/list/{bId}")
    public String list(@PathVariable String bId){

        return "board/list";
    }
}
