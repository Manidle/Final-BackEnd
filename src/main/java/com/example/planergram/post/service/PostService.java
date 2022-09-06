package com.example.planergram.post.service;

import com.example.planergram.post.DTO.PostDTO;
import com.example.planergram.post.model.Board;
import com.example.planergram.post.model.Post;
import com.example.planergram.post.repository.BoardRepository;
import com.example.planergram.post.repository.PostRepository;
import com.example.planergram.user.model.User;
import com.example.planergram.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public PostDTO save(PostDTO postDTO) {
        Post post = makePost(postDTO);
        post = postRepository.save(post);
        return makePostDTO(post);
    }

    public List<PostDTO> findAll() {
        List<Post> postList = postRepository.findAll();
        List<PostDTO> postDTOList = makePostDTOList(postList);
        return postDTOList;
    }

    //게시글 업데이트
    public PostDTO update(Long id, PostDTO postDTO){
        Post post = postRepository.getById(id);
        post.setTitle(postDTO.getTitle());
        post.setContents(postDTO.getContents());
        post.setLikeCount(postDTO.getLikeCount());
        post = postRepository.save(post);
        return makePostDTO(post);
    }

    public PostDTO delete(Long id) {
        Post post = postRepository.getById(id);
        postRepository.delete(post);
        return makePostDTO(post);
    }

    private Post makePost(PostDTO postDTO){
        Board board = boardRepository.getById(postDTO.getBoardId());
        User user = userRepository.getById(postDTO.getUserId());
        return Post.builder()
                .postId(postDTO.getPostId())
                .title(postDTO.getTitle())
                .contents(postDTO.getContents())
                .likeCount(postDTO.getLikeCount())
                .board(board)
                .user(user)
                .build();
    }

    public PostDTO makePostDTO(Post post) {
        return PostDTO
                .builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .contents(post.getContents())
                .likeCount(post.getLikeCount())
                .boardId(post.getBoard().getBoardId())
                .userId(post.getUser().getUserId())
                .build();
    }

    public List<PostDTO> makePostDTOList(List<Post> postList) {
        List<PostDTO> postDTOList = new ArrayList<>();

        for (Post post : postList) {
            postDTOList.add(makePostDTO(post));
        }
        return postDTOList;
    }
}