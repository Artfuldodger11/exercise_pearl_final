package project.mvc.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

import java.util.ArrayList;
import java.util.List;

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

    ModelAndView modelAddFeed = new ModelAndView("addFeed");
    ModelAndView modelFeedsList = new ModelAndView("feedsList");
    UrlValidator urlValidator = new UrlValidatorImpl();

    @RequestMapping(value = "add_feed", method = RequestMethod.GET)
    public ModelAndView processRequest(HttpServletRequest request) throws DBException {


        // URL & Feed Name enter

        if ((urlValidator.validateUrl(request.getParameter("rss_feed_url")))) {

            try {
                RSSFeedParser rssParser = new RSSFeedParserImpl(request.getParameter("rss_feed_url"), request.getParameter("rss_feed_name"));

                // adding feeds to DB
                feed = rssParser.readFeed();
                feedsDao.create(feed);

                //adding items to DB
                itemsList = rssParser.readItems();

                for (Item item : itemsList) {
                    itemsDao.create(item);
                }

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
        feedsList = feedsDao.getAll();
        modelFeedsList.addObject(feedsList);

        request.setAttribute("feedsList", feedsList);
        request.getParameter("RedirectToListPage");
        return new ModelAndView("feedsList", "", null);
    }


    @RequestMapping(value = { "/show-${feedItems}-items" }, method = RequestMethod.GET)
    public ModelAndView showFeedItems(@PathVariable int feedItems) {

        System.out.println(feedItems);
        return new ModelAndView("feedItemsList");
    }


}
