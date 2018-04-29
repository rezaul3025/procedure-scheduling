package org.procedure.scheduling.web.controller;

import org.procedure.scheduling.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String navToRoomListPage(Model model) {
		
		model.addAttribute("rooms", roomService.findAll());
		
		return "room/list";
	}

}
