package com.example.planergram.controller;

import com.example.planergram.DTO.ResponseDTO;
import com.example.planergram.DTO.UserDTO;
import com.example.planergram.model.Post;
import com.example.planergram.model.User;
import com.example.planergram.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    //사용자 등록
    @PostMapping("/join")
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
        try {
            User newUser = userService.save(userDTO);
            UserDTO newUserDTO = userService.makeUserDTO(newUser);
            return ResponseEntity.ok(newUserDTO);
        } catch (Exception e) {
            log.error("회원정보의 등록에 실패했습니다." + e.getMessage());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    //사용자 조회
    @GetMapping("/findall")
    public ResponseEntity<?> findAll() {
        List<User> userList = userService.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            List<Integer> postDTOList = new ArrayList<>();
            for (Post post : user.getPostList()) {
//                postIdList.add(post.getId());
                postDTOList.add(post.getPostId());
            }
            userDTOList.add(
                    UserDTO
                            .builder()
                            .userId(user.getUserId())
                            .loginId(user.getLoginId())
                            .password(user.getPassword())
                            .nickname(user.getNickname())
                            .postDTOList(postDTOList)
                            .build()
            );
        }
        return ResponseEntity.ok(userDTOList);
    }

    // 포스트의 기본키를 가져오는것이 아닌, 제목과 내용을 가져오는 코드
//    @GetMapping("/findall")
//    public ResponseEntity<?> findAll() {
//        List<User> userList = userService.findAll();
//        List<UserDTO> userDTOList = new ArrayList<>();
//        for (User user : userList) {
//            List<String> postTitleDTOList = new ArrayList<>();
//            List<String> postContentDTOList = new ArrayList<>();
//            for (Post post : user.getPostList()) {
//                postIdList.add(post.getId());
//                postTitleDTOList.add(post.getTitle());
//                postContentDTOList.add(post.getContents());
//            }
//            userDTOList.add(
//                    UserDTO
//                            .builder()
//                            .userId(user.getId())
//                            .loginId(user.getLoginId())
//                            .password(user.getPassword())
//                            .nickname(user.getNickname())
//                            .postTitleDTOList(postTitleDTOList)
//                            .postContentDTOList(postContentDTOList)
//                            .build()
//            );
//        }
//        return ResponseEntity.ok(userDTOList);
//    }


    //사용자 업데이트
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody UserDTO updateuserDTO) {
        try {
            User newUser = userService.update(id,updateuserDTO);
            List<Integer> postDTOList = new ArrayList<>();
            for (Post post : newUser.getPostList()) {
                postDTOList.add(post.getPostId());
            }
            UserDTO userDTO = userService.makeUserDTO(newUser);
            return ResponseEntity.ok(userDTO);
        } catch (Exception e) {
            log.error("유저정보 업데이트를 실패하였습니다." + e.getMessage());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    // 사용자 삭제
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        try {
            User newUser = userService.delete(id);
            List<Integer> postList = new ArrayList<>();
            for (Post post : newUser.getPostList()) {
                postList.add(post.getPostId());
            }
            UserDTO userDTO = userService.makeUserDTO(newUser);
            return ResponseEntity.ok(userDTO);
        } catch (Exception e) {
            log.error("회원정보 삭제에 실패했습니다." + e.getMessage());
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}