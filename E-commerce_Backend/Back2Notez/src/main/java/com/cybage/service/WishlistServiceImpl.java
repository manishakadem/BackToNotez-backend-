package com.cybage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.cybage.bean.WishlistBean;
import com.cybage.dao.ProductDao;
import com.cybage.dao.UserDao;
import com.cybage.dao.WishlistDao;
import com.cybage.entity.ProductEntity;
import com.cybage.entity.UserEntity;
import com.cybage.entity.WishlistEntity;

public class WishlistServiceImpl implements WishlistService {

	@Autowired
	private WishlistDao wishlistdao;

	@Autowired
	private ProductDao productdao;

	@Autowired
	private UserDao userdao;

	@Override
	public WishlistBean addWishlist(WishlistBean wishlistBean) {
		WishlistEntity wishlistEntity = new WishlistEntity();
		BeanUtils.copyProperties(wishlistBean, wishlistEntity);

		int userId = wishlistBean.getUser().getUser_id();
		int productId = wishlistBean.getProduct().getProduct_id();

		UserEntity managedUser = userdao.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

		ProductEntity managedProduct = productdao.findById(productId)
				.orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));

		wishlistEntity.setUser(managedUser);
		wishlistEntity.setProduct(managedProduct);

		WishlistEntity savedEntity = wishlistdao.save(wishlistEntity);
		BeanUtils.copyProperties(savedEntity, wishlistBean);
		wishlistBean.setUser(savedEntity.getUser());
		wishlistBean.setProduct(savedEntity.getProduct());

		return wishlistBean;
	}

	@Override
	public List<WishlistBean> displayWishlist() {
		List<WishlistBean> listWishlistBean = null;
		List<WishlistEntity> listWishlistEntity = wishlistdao.findAll();
		if (listWishlistEntity != null) {
			listWishlistBean = new ArrayList<>();
			for (WishlistEntity wishlistEntity : listWishlistEntity) {
				WishlistBean wishlistbean = new WishlistBean();
				BeanUtils.copyProperties(wishlistEntity, wishlistbean);
				listWishlistBean.add(wishlistbean);

			}
		}
		return listWishlistBean;

	}

	@Override
	public WishlistBean updateWishlist(WishlistBean wishlistbean) {
		Optional<WishlistEntity> requiredWishlistEntity = wishlistdao.findById(wishlistbean.getWishlist_id());
		if (requiredWishlistEntity.isPresent()) {
			WishlistEntity updateWishlistEntity = requiredWishlistEntity.get();

			BeanUtils.copyProperties(wishlistbean, updateWishlistEntity);
			wishlistdao.save(updateWishlistEntity);

			WishlistBean newWishlistBean = new WishlistBean();
			BeanUtils.copyProperties(updateWishlistEntity, newWishlistBean);
			return newWishlistBean;
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteWishlist(int id) {
		if (wishlistdao.existsById(id)) {
			wishlistdao.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
