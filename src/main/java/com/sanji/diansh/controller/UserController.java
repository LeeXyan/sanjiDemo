package com.sanji.diansh.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sanji.diansh.entity.Unit;
import com.sanji.diansh.entity.User;
import com.sanji.diansh.repository.UnitRepository;
import com.sanji.diansh.repository.UserRepository;
import com.sanji.diansh.service.UnitService;
import com.sanji.diansh.service.UserService;



@Controller
@RequestMapping("/admin/list")
public class UserController {

	Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService us;
	
	@Autowired
	private UnitService unitsr;
	
	@Autowired
	private UserRepository  ur;
	
	@Autowired
    private UnitRepository unitur;
	
    public void execute(HttpServletRequest request,HttpServletResponse response){
    	
    	
    }
    


	/**
	 * 得到列表并且分页
	 * @param pageable
	 * @param assembler
	 * @param model
	 * @param imei
	 * @return
	 */
	@RequestMapping(value="/list3",method = RequestMethod.GET)
	public String list1(Pageable pageable, PagedResourcesAssembler<User> assembler,Model model,String imei){
		System.out.println("imei="+imei);
		 Pattern pattern = Pattern.compile("[0-9]*");
		 if(imei!= null){
			 Matcher match = pattern.matcher(imei);
			 if(match.matches()==false){
				 Page<User> users = us.findAll2(imei, pageable);
				 model.addAttribute("data", assembler.toResource(users));
				 model.addAttribute("meta", assembler.toResource(users).getMetadata());
			 }
		 }else{
			 Page<User> users = us.findAll(imei, pageable);
			 model.addAttribute("data", assembler.toResource(users));
			 model.addAttribute("meta",assembler.toResource(users).getMetadata());
		 }
		return "admin/list/list4";
		
	}
	/**
	 * 得到列表并且分页
	 * @param pageable
	 * @param assembler
	 * @param model
	 * @param imei
	 * @return
	 */
	@RequestMapping(value="/unit",method = RequestMethod.GET)
	public String listUnit(Pageable pageable, PagedResourcesAssembler<Unit> assembler,Model model,String imei){
		///System.out.println("imei="+imei);
		 Pattern pattern = Pattern.compile("[0-9]*");
		 if(imei!= null){
			 Matcher match = pattern.matcher(imei);
			 if(match.matches()==false){
				 Page<Unit> users = unitsr.findAll2(imei, pageable);
				 model.addAttribute("data", assembler.toResource(users));
				 model.addAttribute("meta", assembler.toResource(users).getMetadata());
			 }
		 }else{
			 Page<Unit> users = unitsr.findAll(imei, pageable);
			 model.addAttribute("data", assembler.toResource(users));
			 model.addAttribute("meta",assembler.toResource(users).getMetadata());
		 }
		return "admin/unit/list";
		
	}
	
    /*
    //查询所有没有分页
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model){
		List<User> list1=ur.findAll();
		//long count = ur.count();
		//int page = pageBase.getPage(count, 20)+1;
		model.addAttribute("data",list1);
		return "admin/list/list2";
	}*/
	
	
	
    //查询所有 有分页 但是不能翻页还是第一页
	/*@RequestMapping(value="/list1",method = RequestMethod.GET)
	public String list(PagedResourcesAssembler<User> assembler,Model model){
		Page<User> page1=ps.findAll(new PageRequest(0, 20,new Sort(Direction.DESC,"id")));
		//log.info("nihao");
		
		
		PagedResources p=assembler.toResource(page1);
		PageMetadata p1=assembler.toResource(page1).getMetadata();
		
		
		model.addAttribute("data",assembler.toResource(page1));
		model.addAttribute("page",assembler.toResource(page1).getMetadata());
		return "admin/list/list5";
	}*/
	
	/**
	 * 根据用户名查询
	 * @param assembler
	 * @param pageable
	 * @param model
	 * @param imei
	 * @return
	 */
	@RequestMapping(value="/findByusername/{imei}",method = RequestMethod.GET)
	public String findByusername(PagedResourcesAssembler<User> assembler,Pageable pageable,Model model,@PathVariable(value="imei")String imei){
		 Page<User> users = ur.findByname(imei, pageable);
		 model.addAttribute("data", assembler.toResource(users));
		 model.addAttribute("meta",assembler.toResource(users).getMetadata());
		return "admin/list/list4";
	}
	@RequestMapping(value="/unit/findByusername/{imei}",method = RequestMethod.GET)
	public String findByusername1(PagedResourcesAssembler<Unit> assembler,Pageable pageable,Model model,@PathVariable(value="imei")String imei){
		 Page<Unit> unit = unitur.findByname(imei, pageable);
		 model.addAttribute("data", assembler.toResource(unit));
		 model.addAttribute("meta",assembler.toResource(unit).getMetadata());
		return "admin/unit/list";
	}
	/**
	 * 根据手机号查询
	 * @param assembler
	 * @param pageable
	 * @param model
	 * @param imei
	 * @return
	 */
	@RequestMapping(value="/findBymobile/{imei}",method = RequestMethod.GET)
	public String findBymobile(PagedResourcesAssembler<User> assembler,Pageable pageable,Model model,@PathVariable(value="imei")String imei){
		 Page<User> users = ur.findBymobile(imei, pageable);
		 model.addAttribute("data", assembler.toResource(users));
		 model.addAttribute("meta",assembler.toResource(users).getMetadata());
		return "admin/list/list4";
	}
	
	@RequestMapping(value="/unit/findBymobile/{imei}",method = RequestMethod.GET)
	public String findBymobile1(PagedResourcesAssembler<Unit> assembler,Pageable pageable,Model model,@PathVariable(value="imei")String imei){
		// Page<User> users = ur.findBymobile(imei, pageable);
		 //Unit unit = unitur.findByUserId()
		 Page<Unit> unit = unitur.findBymobile(imei, pageable);
		 model.addAttribute("data", assembler.toResource(unit));
		 model.addAttribute("meta",assembler.toResource(unit).getMetadata());
		return "admin/unit/list";
	}
	/**
	 * 进入增加页面
	 * @return
	 */
	@RequestMapping(value="/add2",method = RequestMethod.GET)
	public  String  add(){
		return "admin/list/add";
	}
	
	@RequestMapping(value="/unit/add2",method = RequestMethod.GET)
	public  String  addunit(){
		return "admin/unit/add";
	}
	
	/**
	 * 添加数据
	 * @param username
	 * @param password
	 * @param mobile
	 * @param roler
	 * @return
	 */
	/*@RequestMapping(value="/add",method = RequestMethod.POST)
	public  String  add(@RequestParam(value = "username")String username,@RequestParam(value = "password")String password,@RequestParam(value = "mobile")String mobile,@RequestParam(value = "roler")String roler){
       User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setMobile(mobile);
		user.setRoler(roler);
		ur.save(user);
		
		return "admin/list/list4";
	}*/
	
	/**添加数据
	 * @RequestBody 从前端传过来的是json字符 不是json对象 传过来可以用对象接收
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public  String  add(@RequestBody User user){
		System.out.println("user.getLastModifiedBy()"+user.getLastModifiedBy());
		DateTime createdDate =  DateTime.now();
		user.setCreatedDate(createdDate);
		ur.save(user);
		return "admin/list/list4";
	}
	
	
	@RequestMapping(value="/unit/add",method = RequestMethod.POST)
	public  String  addbyUnit(PagedResourcesAssembler<Unit> assembler,Pageable pageable,Model model,String imei,@RequestParam(value = "username")String username,@RequestParam(value = "password")String password,@RequestParam(value = "mobile")String mobile,@RequestParam(value = "roler")String roler,@RequestParam(value = "address")String address){
		
		User user = new User();
		DateTime createdDate =  DateTime.now();
		user.setCreatedDate(createdDate);
		user.setUsername(username);
		user.setPassword(password);
		user.setMobile(mobile);
		user.setRoler(roler);
		ur.save(user);
		///System.out.println("address="+address);
		Unit unit = new Unit();
		unit.setCreatedDate(createdDate);
		unit.setAddress(address);
		unit.setUser(user);
		unitur.save(unit);
		
		
		
		 Pattern pattern = Pattern.compile("[0-9]*");
		 if(imei!= null){
			 Matcher match = pattern.matcher(imei);
			 if(match.matches()==false){
				 Page<Unit> users = unitsr.findAll2(imei, pageable);
				 model.addAttribute("data", assembler.toResource(users));
				 model.addAttribute("meta", assembler.toResource(users).getMetadata());
			 }
		 }else{
			 Page<Unit> users = unitsr.findAll(imei, pageable);
			 model.addAttribute("data", assembler.toResource(users));
			 model.addAttribute("meta",assembler.toResource(users).getMetadata());
		 }
		 
		return "admin/unit/list";
	}
	

	/**
	 * 更新页面得到数据
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update1/{id}")
	public  String  update1(@PathVariable(value="id") Long id,Model model){
		User u=ur.findOne(id);
		model.addAttribute("data", u);
		return "admin/list/update";
	}
	
	@RequestMapping(value="/unit/update1/{id}")
	public  String  updateByUnit(@PathVariable(value="id") Long id,Model model){
		Unit u=unitur.findOne(id);
		model.addAttribute("data", u);
		return "admin/unit/update";
	}
	

	/**
	 * 详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/details1/")
	public  String  details1(){
		return "admin/list/details";
	}
	@RequestMapping(value="/details/{id}")
	public  String  details(@PathVariable(value="id") Long id,Model model){
		User u=ur.findOne(id);
		model.addAttribute("data", u);
		return "admin/list/details";
	}
	
	
	/**
	 * 详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="unit/details1/")
	public  String  unitDetails1(){
		return "admin/unit/details";
	}
	@RequestMapping(value="unit/details/{id}")
	public  String  unitDetails(@PathVariable(value="id") Long id,Model model){
		Unit u=unitur.findOne(id);
		model.addAttribute("data", u);
		return "admin/unit/details";
	}
	
	
	/**
	 * 返回并且进去更新页面
	 * @return
	 */
	@RequestMapping(value="/update2")
	public  String  update2(){
		return "admin/list/update";
	}
	
	@RequestMapping(value="/unit/update2")
	public  String  updateByunit1(){
		return "admin/unit/update";
	}
	
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
	public String del(@PathVariable(value="id")Long id){
		System.out.println("id=="+id);
		
		ur.delete(id);
		return "admin/list/list4";
	}
	
	
	@RequestMapping(value = "/unit/del/{id}",method = RequestMethod.POST)
	public String delByUnit(@PathVariable(value="id")Long id){
		Unit unit=unitur.findByUserId(id);
		unitur.delete(unit);
		return "admin/list/list4";
	}
	
	
	/**
	 * 进行数据更新
	 * @param id
	 * @param username
	 * @param password
	 * @param mobile
	 * @param roler
	 * @return
	 */

	/*@RequestMapping(value="/update")
	public String update(@RequestParam(value = "id")Long id,@RequestParam(value = "username")String username,@RequestParam(value = "password")String password,@RequestParam(value = "mobile")String mobile,@RequestParam(value = "roler")String roler){
		ur.delete(id);
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setMobile(mobile);
		user.setRoler(roler);
		ur.save(user);
		return "admin/list/list4";
	}*/
	
	@RequestMapping(value="/update")
	@Transactional
	public String update(@RequestBody User user){
		User u=ur.findOne(user.getId());
		DateTime lastModifiedDate =  DateTime.now();
		user.setCreatedDate(u.getCreatedDate());
		user.setLastModifiedDate(lastModifiedDate);
		ur.save(user);
		
		return "admin/list/list4";
	}
	
	
	@RequestMapping(value="/unit/update")
	public String updateByUnit3(@RequestParam(value = "user_id")Long user_id,@RequestParam(value = "username")String username,@RequestParam(value = "password")String password,@RequestParam(value = "mobile")String mobile,@RequestParam(value = "roler")String roler,@RequestParam(value = "address")String address,@RequestParam(value = "id")Long id){
		User user = new User();
		User u =  ur.findOne(user_id);
		DateTime lastModifiedDate =  DateTime.now();
		user.setCreatedDate(u.getCreatedDate());
		user.setLastModifiedDate(lastModifiedDate);
		user.setUsername(username);
		user.setPassword(password);
		user.setMobile(mobile);
		user.setRoler(roler);
		
		unitur.delete(id);
		Unit unit =  new Unit();
		unit.setCreatedDate(u.getCreatedDate());
		unit.setLastModifiedDate(lastModifiedDate);
		unit.setAddress(address);
		unit.setUser(user);
		
		unitur.save(unit);
		return "admin/unit/list";
	}
}
