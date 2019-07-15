package techcourse.myblog.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepository {
    private List<Article> articles = new ArrayList<>();

    public List<Article> findAll() {
        return articles;
    }

    public Article getArticleById(final int id) {
        return articles.get(id);
    }

    public void addArticle(final Article article) {
        articles.add(article);
    }
}
