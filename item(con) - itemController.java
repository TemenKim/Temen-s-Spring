package com.koreait.item.domain.web.basic;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.item.domain.item.Item;
import com.koreait.item.domain.item.ItemRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
/*
 * @RequiredArgsConstructor : 
 * final이 붙은 멤버변수만 사용해서 생성자를 자동으로 만들어준다.
 */
public class BasicItemController {
	
	private final ItemRepository itemRepository;
	
	//@Autowired
	/*
	 * 생성자가 딱 1개만 있으면 스프링이 
	 * 해당 생성자에게 @Autowired로 의존관계를 주입해준다.
	 */
//	public BasicItemController(ItemRepository itemRepository) {
//		this.itemRepository = itemRepository;
//	}

	@GetMapping
	public String items(Model model) {
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);
		return "basic/items";
	}
	
	
	@GetMapping("/add")
	public String addForm(Model model) {
		return "basic/addForm";
	}
	
	@GetMapping("/{itemId}")
	public String item(@PathVariable long itemId  ,Model model) {
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item",item);
		return "basic/item";
	}
	
	
	/*
	 * 테스트용 데이터 추가
	 */
	@PostConstruct
	public void init() {
//		System.out.println("초기화 메서드");
		itemRepository.save(new Item("testA", 1000, 10));
		itemRepository.save(new Item("testB", 2000, 20));
		itemRepository.save(new Item("testC", 3000, 30));
	}
	
	/*
	 * 종료 메서드
	 */
//	@PreDestroy
//	public void destroy() {
//		System.out.println("종료 메서드 호출");
//	}
	
	
	
	
}
















