package jpabook.jpashop.service;

import jpabook.jpashop.domain.Item.Book;
import jpabook.jpashop.domain.Item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    /**
     * 영속성 컨텍스트가 자동 변경 */
    @Transactional
//    public void updateItem(Long itemId, Book param) { // 변경 감지 가능을 사용한 메소드이다 !
    public void updateItem(Long itemId, String name, int price, int stockQuantity) { // 변경 될만한 것만 넘겨와서 바꾸는 방법
        Item findItem = itemRepository.findOne(itemId);
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);
    }



    public Item findOne(Long id) {
        return itemRepository.findOne(id);
    }
    public List<Item> findItems() {
        return itemRepository.findAll();
    }
}
