package project.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="feeds")
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "url" )
    String feedUrl;
    @Column(name = "title" )
    String feedTitle;
    @Column(name = "last_update" )
    String feedLast_update;
    @Column(name = "feed_name" )
    String feed_name;

    public Feed() {

    }


    public int getId() {
        return id;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public void setFeedUrl(String feedUrl) {
        this.feedUrl = feedUrl;
    }

    public String getFeedTitle() {
        return feedTitle;
    }

    public void setFeedTitle(String feedTitle) {
        this.feedTitle = feedTitle;
    }

    public String getFeedLast_update() {
        return feedLast_update;
    }

    public void setFeedLast_update(String feedLast_update) {
        this.feedLast_update = feedLast_update;
    }

    public String getFeed_name() {
        return feed_name;
    }

    public void setFeed_name(String feed_name) {
        this.feed_name = feed_name;
    }

    public Feed(String feedUrl, String feedTitle, String feedLast_update, String feed_name) {
        this.feedUrl = feedUrl;
        this.feedTitle = feedTitle;
        this.feedLast_update = feedLast_update;
        this.feed_name = feed_name;

    }





}
