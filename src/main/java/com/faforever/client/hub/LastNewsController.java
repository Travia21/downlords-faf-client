package com.faforever.client.hub;

import com.faforever.client.i18n.I18n;
import com.faforever.client.news.NewsItem;
import com.faforever.client.news.NewsService;
import com.faforever.client.preferences.PreferencesService;
import com.faforever.client.util.ThemeUtil;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

public class LastNewsController {

  @FXML
  Label textLabel;
  @FXML
  Label titleLabel;
  @FXML
  Label authoredLabel;
  @FXML
  Node lastNewsRoot;
  @FXML
  ImageView imageView;

  @Autowired
  NewsService newsService;
  @Autowired
  PreferencesService preferencesService;
  @Autowired
  I18n i18n;

  public Node getRoot() {
    return lastNewsRoot;
  }

  @PostConstruct
  void postConstruct() {
    String theme = preferencesService.getPreferences().getTheme();

    List<NewsItem> newsItems = newsService.fetchNews();
    NewsItem newsItem = newsItems.get(0);
    authoredLabel.setText(i18n.get("news.authoredFormat", newsItem.getAuthor(), newsItem.getDate()));

    titleLabel.setText(newsItem.getTitle());

    String text = Jsoup.parse(newsItem.getContent()).text();
    textLabel.setText(text);

    // TODO only use this if there's no thumbnail. However, there's never a thumbnail ATM.
    imageView.setImage(new Image(ThemeUtil.themeFile(theme, "images/news_fallback.jpg")));
  }
}