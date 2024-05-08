package br.com.springboot3.services;

import br.com.springboot3.controller.BookController;
import br.com.springboot3.data.vo.v1.BookVO;
import br.com.springboot3.exception.ResourceNotFoundException;
import br.com.springboot3.mapper.DozzerMapper;
import br.com.springboot3.model.Book;
import br.com.springboot3.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookServices {
    private Logger logger = Logger.getLogger(BookServices.class.getName());

    @Autowired
    private BookRepository bookRepository;

//    @Autowired
//    private BookMapper mapper;

    public BookVO createBook(BookVO book){
        logger.info("Creating book!");
        var entity = DozzerMapper.parseObject(book,Book.class);

        var vo =  DozzerMapper.parseObject(bookRepository.save(entity), BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }


    public BookVO updateBook(BookVO book){
        logger.info("Update book!");
        var entity = bookRepository.findById(book.getKey()).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID! "));

        entity.setTitle(book.getTitle());
        entity.setPrice(book.getPrice());
        entity.setLauchDate(book.getLauchDate());
        entity.setAuthor(book.getAuthor());
        BookVO vo  =  DozzerMapper.parseObject(bookRepository.save(entity), BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public BookVO findById(Long id){
        logger.info("Finding one Book!");

        var entity =  bookRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID! "));

        var vo = DozzerMapper.parseObject(entity, BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id){
        var entity = bookRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID! "));

        bookRepository.delete(entity);
    }

    public List<BookVO> findAll(){
       var books =  DozzerMapper.parseListObjects(bookRepository.findAll(),BookVO.class);
       books.forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
       return books;
    }


}
