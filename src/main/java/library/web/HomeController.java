package library.web;

import library.model.bindingmodel.BookStoreBindingModel;
import library.model.service.BookStoreServiceModel;
import library.service.BookStoreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

	private final ModelMapper modelMapper;
	private final BookStoreService bookStoreService;

	@Autowired
	public HomeController(ModelMapper modelMapper, BookStoreService bookStoreService) {
		this.modelMapper = modelMapper;
		this.bookStoreService = bookStoreService;
	}
	
}
