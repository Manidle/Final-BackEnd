package com.example.planergram.post.service;

import com.example.planergram.post.DTO.PostDTO;
import com.example.planergram.post.model.Board;
import com.example.planergram.post.model.Post;
import com.example.planergram.user.model.User;
import com.example.planergram.post.repository.BoardRepository;
import com.example.planergram.post.repository.PostRepository;
import com.example.planergram.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public Post save(PostDTO postDTO) throws Exception {
        Board board = boardRepository.findById(postDTO.getBoardId()).orElseThrow(Exception::new);
        User user = userRepository.findById(postDTO.getUserId()).orElseThrow(Exception::new);
        Post newPost = Post
                .builder()
                .postId(postDTO.getPostId())
                .title(postDTO.getTitle())
                .contents(postDTO.getContents())
                .likeCount(postDTO.getLikeCount())
                .board(board)
                .user(user)
                .build();
        return postRepository.save(newPost);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public List<Post> delete(Long id) {
        final Optional<Post> foundPost = postRepository.findById(id);
        foundPost.ifPresent(post -> {
            postRepository.delete(post);
        });
        return postRepository.findAll();
    }

    //게시글 업데이트
    public Post update(Long id, PostDTO postDTO) throws Exception {
        Post findPost = postRepository.findById(id).orElseThrow(Exception::new);
        findPost.setTitle(postDTO.getTitle());
        findPost.setContents(postDTO.getContents());
        findPost.setLikeCount(postDTO.getLikeCount());
        return postRepository.save(findPost);
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