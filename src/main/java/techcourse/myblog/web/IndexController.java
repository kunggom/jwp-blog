package techcourse.myblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import techcourse.myblog.domain.Article;
import techcourse.myblog.domain.ArticleRepository;
import techcourse.myblog.domain.BlogName;

import java.util.List;

@Controller
public class IndexController {
    private final ArticleRepository articleRepository;

    public IndexController(final ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/")
    public String getIndex(final Model model, @RequestParam(value = "blogName", required = false) final String blogName) {
        final BlogName name = new BlogName(blogName);
        final List<Article> articles = articleRepository.getAll();
        model.addAttribute("blogName", name);
        model.addAttribute("articles", articles);
        return "index";
    }
}
