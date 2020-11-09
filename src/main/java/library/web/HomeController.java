package library.web;

import library.service.BookStoreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
