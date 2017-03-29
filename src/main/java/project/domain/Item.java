package project.domain;


import javax.persistence.*;


@Entity
@Table(name="items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "title")
    String itemTitle;
    @Column(name = "link")
    String itemLink;
    @Column(name = "description", columnDefinition = "TEXT")
    String itemDescription;
    @Column(name = "published")
    String itemPublished;




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

    public String getItemPublished() {
        return itemPublished;
    }

    public void setItemPublished(String itemPublished) {
        this.itemPublished = itemPublished;
    }


}