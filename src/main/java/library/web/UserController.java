package library.web;

import library.model.views.UserViewModel;
import library.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<UserViewModel>> getAllUsers(){
        List<UserViewModel> users = this.userService.getAllUser()
                .stream().map(u -> this.modelMapper.map(u, UserViewModel.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
