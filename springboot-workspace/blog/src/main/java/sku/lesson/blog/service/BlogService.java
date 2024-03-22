package sku.lesson.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sku.lesson.blog.domain.Article;
import sku.lesson.blog.dto.AddArticleRequest;
import sku.lesson.blog.repository.BlogRepository;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
}
