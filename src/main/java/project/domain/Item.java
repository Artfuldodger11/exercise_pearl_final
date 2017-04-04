package project.domain;


import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;



@Entity
@Table(name="items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column (name = "feed_id")
    Integer feed_id;
    @Column(name = "title")
    String itemTitle;
    @Column(name = "link")
    String itemLink;
    @Column(name = "description", columnDefinition = "TEXT")
    String itemDescription;
    @Column(name = "published" , columnDefinition = "DATETIME")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm:ss'Z'")
    LocalDateTime itemPublished;



    public Item() {
    }

    public Integer getFeed_id() {
        return feed_id;
    }

    public void setFeed_id(Integer feed_id) {
        this.feed_id = feed_id;
    }

    public Integer getId() {
        return id;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemLink() {
        return itemLink;
    }

    public void setItemLink(String itemLink) {
        this.itemLink = itemLink;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public LocalDateTime getItemPublished() {
        return itemPublished;
    }

    public void setItemPublished(LocalDateTime itemPublished) {
        this.itemPublished = itemPublished;
    }


}