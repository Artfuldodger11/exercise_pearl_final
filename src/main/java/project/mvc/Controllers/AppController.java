package project.mvc.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;
import project.database.DBException;
import project.database.FeedsDAO;

import project.database.ItemsDAO;
import project.domain.Feed;
import project.domain.Item;
import project.service.RSSFeedParser;
import project.service.RSSFeedParserImpl;
import project.service.UrlValidator;
import project.service.UrlValidatorImpl;

import javax.servlet.http.HttpServletRequest;

import java.util.*;


@Controller
@RequestMapping ("/")
public class AppController {

    @Autowired
    @Qualifier("ORM_FeedsDAO")
    private FeedsDAO feedsDao;

    @Autowired
    @Qualifier("ORM_ItemsDAO")
    private ItemsDAO itemsDao;

    Feed feed = new Feed();
    List<Item> itemsList = new ArrayList<>();
    List<Feed> feedsList = new ArrayList<>();



    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public ModelAndView indexPageButton(HttpServletRequest request) {

        if (request.getParameter("RedirectToListPage") != null) {
            return new ModelAndView("addFeed", "", null);
        }

        return new ModelAndView("main", "model", null);

    }

    @RequestMapping(value = "add_feed", method = RequestMethod.GET)
    public ModelAndView urlAndFeedEnter(HttpServletRequest request) throws DBException {

        ModelAndView modelAddFeed = new ModelAndView("addFeed");
        UrlValidator urlValidator = new UrlValidatorImpl();

        // URL & Feed Name enter

        if ((urlValidator.validateUrl(request.getParameter("rss_feed_url")))) {

            try {
                RSSFeedParser rssParser = new RSSFeedParserImpl(request.getParameter("rss_feed_url"), request.getParameter("rss_feed_name"));

                //paring feeds and items and adding to db

                feed = rssParser.readFeed();
                itemsList = rssParser.readItems();


                feed.setItemList(itemsList);

                for(Item item : itemsList) {
                    itemsDao.create(item);
                }
                feedsDao.create(feed);



                modelAddFeed.addObject("Feed_added_message", "Feed added : " + feed.getFeed_name());
                return modelAddFeed;
            } catch (DBException e) {
                modelAddFeed.addObject("Feed_added_message", "DB error");
                return modelAddFeed;
            }

        } else {
            modelAddFeed.addObject("Feed_added_message", "Incorrect Url");
            return modelAddFeed;
        }

    }

    @RequestMapping(value = "/feedList", method = {RequestMethod.GET})
    public ModelAndView redirectToListPage(HttpServletRequest request) throws DBException {

        // Feeds List
        try {
            feedsList = feedsDao.getAll();
            request.setAttribute("feedsList", feedsList);
            return new ModelAndView("feedsList");
        } catch (DBException e) {
            return new ModelAndView("feedsList");
        }
    }


    @RequestMapping(value = { "{feedItems}" }, method = RequestMethod.GET)
    public ModelAndView showFeedItems(@PathVariable int feedItems, HttpServletRequest request) throws DBException {

        //add items list related to specific feed
        //add specific feed name

        try {
        Map<String, Object> model = new HashMap<String, Object>();

        List<?> feedItemsList = itemsDao.getItemsListByFeedId(feedItems);

        model.put("feedItemsList", feedItemsList);

        Feed feedName = feedsDao.getFeedById(feedItems);
        model.put("feedName", feedName);

        return new ModelAndView("feedItemsList", "model", model);

       }catch (DBException e) {
        return new ModelAndView("feedItemsList", "model", "DB error");
    }

   }
}
