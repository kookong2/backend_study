package org.koreait.controllers.admins;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.koreait.commons.errors.CommonException;
import org.koreait.models.board.BoardInfoService;
import org.koreait.models.board.BoardListService;
import org.koreait.models.board.BoardSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/board")
public class BoardController {

    @Autowired
    private BoardSaveService saveService;
    @Autowired
    private BoardListService listService;
    @Autowired
    private BoardInfoService infoService;
    @GetMapping
    public String index(Model model){
        List<BoardConfig> configs = listService.gets();
        model.addAttribute("configs",configs);

        return "admin/board/index";
    }

    @GetMapping("/update/{bIb}")
    public String update(@PathVariable String bId, Model model, HttpServletResponse response){
        model.addAttribute("mode","update");

        try {
            BoardConfig boardConfig = infoService.get(bId);
            model.addAttribute("boardConfig",boardConfig);
        }catch (CommonException e){
            response.setStatus(e.getStatus());
            model.addAttribute("script","alert('" + e.getMessage() + "');history.back();");
            return "commons/execute_script";
        }

        return "admin/board/update";
    }

    /**
     * 개시판 등록
     * @return
     */

    @GetMapping("/register")
    public String register(Model model){
        BoardConfig boardConfig = new BoardConfig();
        model.addAttribute("boardConfig",boardConfig);

        return "admin/board/register";
    }

    /**
     * 게시판 등록 & 수정
     * @return
     */
    @PostMapping("/save")
    public String boardConfigSave(@Valid BoardConfig boardConfig, Errors errors){
        String mode = boardConfig.getMode();
        if(errors.hasErrors()){
            String tpl = "admin/board/";
            if (mode != null && mode.equals("update")){
                tpl += "update";
            } else {
                tpl += "register";
            }
            return tpl;
        }

        saveService.save(boardConfig);

        return "redirect:/admin/board"; // 게시판 등록 & 수정 -> 목록
    }
}
