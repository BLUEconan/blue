package edu.hziee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.hziee.dao.BookDao;
import edu.hziee.models.Book;

@Controller
@RequestMapping("/book")
public class BookContreller {
   @Autowired
   private BookDao bookDao;
   
   @RequestMapping(method=RequestMethod.GET)
   public ModelAndView getAll(){
	   ModelAndView mav=new ModelAndView("book/bookList");
	   List<Book> books=bookDao.findAll();
	   System.out.println(books.size());
	   mav.addObject("books",books);
	   return mav;
   }
   @RequestMapping(value="/{id}", method=RequestMethod.GET)
   public ModelAndView getA(@PathVariable int id){
	   ModelAndView mav=new ModelAndView("book/book");
	   Book book=bookDao.findById(id);
	   mav.addObject("book",book);
	   return mav;
   }
   @RequestMapping(value="/add", method=RequestMethod.GET)
   public ModelAndView add(){
	   ModelAndView mav=new ModelAndView("book/addBook");
	   return mav;
   }
   @RequestMapping(value="/add", method=RequestMethod.POST)
   public ModelAndView add(@RequestParam String title,@RequestParam String author,@RequestParam String brief){
	   Book book=new Book();
	   book.setAuthor(author);
	   book.setBrief(brief);
	   book.setTitle(title);
	   bookDao.add(book);
	   
	   
	   ModelAndView mav=new ModelAndView("redirect:/book");
	   return mav;
   }
   @RequestMapping(value="/delete", method=RequestMethod.GET)
   public ModelAndView delete(@RequestParam int id){
	   bookDao.delete(id);
	   ModelAndView mav=new ModelAndView("redirect:/book");
	   return mav;
   }
   @RequestMapping(value="/edit", method=RequestMethod.GET)
   public ModelAndView edit(@RequestParam int id){
	   Book book=bookDao.findById(id);
	   ModelAndView mav=new ModelAndView("book/editBook");
	   mav.addObject("book", book);
	   return mav;
   }
   @RequestMapping(value="/edit", method=RequestMethod.POST)
   public ModelAndView edit(@RequestParam int id,@RequestParam String title,@RequestParam String brief,@RequestParam String author){
	   Book book=new Book();
	   book.setId(id);
	   book.setAuthor(author);
	   book.setBrief(brief);
	   book.setTitle(title);
	   
	   bookDao.modify(book);
	   
	   ModelAndView mav=new ModelAndView("redirect:/book");
	   return mav;
   }
}
