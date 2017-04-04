package project.domain;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="feeds")
public class Feed {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "url" )
    String feedUrl;
    @Column(name = "title" )
    String feedTitle;
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm:ss'Z'")
    @Column(name = "last_update" , columnDefinition = "DATETIME" )
    LocalDateTime feedLast_update;
    @Column(name = "feed_name" )
    String feed_name;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name = "feed_id")
    private List<Item> itemList;

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Feed () {}


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

    public LocalDateTime getFeedLast_update() {
        return feedLast_update;
    }

    public void setFeedLast_update(LocalDateTime feedLast_update) {
        this.feedLast_update = feedLast_update;
    }

    public String getFeed_name() {
        return feed_name;
    }

    public void setFeed_name(String feed_name) {
        this.feed_name = feed_name;
    }

    public Feed(String feedUrl, String feedTitle, LocalDateTime feedLast_update, String feed_name) {
        this.feedUrl = feedUrl;
        this.feedTitle = feedTitle;
        this.feedLast_update = feedLast_update;
        this.feed_name = feed_name;

    }

}
