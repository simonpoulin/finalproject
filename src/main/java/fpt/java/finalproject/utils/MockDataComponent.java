package fpt.java.finalproject.utils;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import fpt.java.finalproject.models.Brand;
import fpt.java.finalproject.models.CartDetail;
import fpt.java.finalproject.models.Category;
import fpt.java.finalproject.models.Employee;
import fpt.java.finalproject.models.EmployeeRole;
import fpt.java.finalproject.models.Order;
import fpt.java.finalproject.models.OrderDetail;
import fpt.java.finalproject.models.OrderStatus;
import fpt.java.finalproject.models.Product;
import fpt.java.finalproject.models.Recipient;
import fpt.java.finalproject.models.Shop;
import fpt.java.finalproject.models.ShopEmployee;
import fpt.java.finalproject.models.ShopItem;
import fpt.java.finalproject.models.ShopPack;
import fpt.java.finalproject.models.ShopRole;
import fpt.java.finalproject.models.User;
import fpt.java.finalproject.repositories.BrandRepository;
import fpt.java.finalproject.repositories.CartDetailRepository;
import fpt.java.finalproject.repositories.CategoryRepository;
import fpt.java.finalproject.repositories.EmployeeRepository;
import fpt.java.finalproject.repositories.EmployeeRoleRepository;
import fpt.java.finalproject.repositories.OrderDetailRepostitory;
import fpt.java.finalproject.repositories.OrderReposirory;
import fpt.java.finalproject.repositories.OrderStatusRepository;
import fpt.java.finalproject.repositories.ProductRepository;
import fpt.java.finalproject.repositories.RecipientRepository;
import fpt.java.finalproject.repositories.ShopEmployeeRepository;
import fpt.java.finalproject.repositories.ShopItemRepository;
import fpt.java.finalproject.repositories.ShopPackRepository;
import fpt.java.finalproject.repositories.ShopRepository;
import fpt.java.finalproject.repositories.ShopRoleRepository;
import fpt.java.finalproject.repositories.UserRepository;

@Component
public class MockDataComponent implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ShopItemRepository shopItemRepository;

    @Autowired
    CartDetailRepository cartDetailRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderReposirory orderRepostitory;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Autowired
    RecipientRepository recipientRepository;

    @Autowired
    OrderDetailRepostitory orderDetailRepostitory;

    @Autowired
    ShopRoleRepository shopRoleRepository;

    @Autowired
    ShopPackRepository shopPackRepository;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ShopEmployeeRepository shopEmployeeRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        // Add role
        if (!employeeRoleRepository.findById(1).isPresent()) {
            EmployeeRole er = new EmployeeRole();
            er.setId(1);
            er.setRoleName("Employee");
            employeeRoleRepository.save(er);
        }
        if (!employeeRoleRepository.findById(2).isPresent()) {
            EmployeeRole er = new EmployeeRole();
            er.setId(2);
            er.setRoleName("Manager");
            employeeRoleRepository.save(er);
        }
        if (!employeeRoleRepository.findById(3).isPresent()) {
            EmployeeRole er = new EmployeeRole();
            er.setId(3);
            er.setRoleName("Admin");
            employeeRoleRepository.save(er);
        }

        // Admin account
        if (!employeeRepository.findByUsername("vunam").isPresent()) {
            Employee manager = new Employee();
            manager.setUsername("vunam");
            manager.setPassword(passwordEncoder.encode("123456"));
            manager.setAddress("Quảng Nam");
            manager.setCreatedAt(new Date(new Date().getTime()));
            manager.setEmail("Vunam@gmail.com");
            manager.setName("Vũ Nam");
            manager.setPhone("0934567890");
            EmployeeRole employeeRole = employeeRoleRepository.findById(3).get();
            manager.setEmployeeRole(employeeRole);
            employeeRepository.save(manager);
        }
        if (!employeeRepository.findByUsername("Callmerey").isPresent()) {
            Employee manager = new Employee();
            manager.setUsername("Callmerey");
            manager.setPassword(passwordEncoder.encode("123456"));
            manager.setAddress("Quảng Nam");
            manager.setCreatedAt(new Date(new Date().getTime()));
            manager.setEmail("callmery@gmail.com");
            manager.setName("Thanh Son");
            manager.setPhone("0834567890");
            EmployeeRole employeeRole = employeeRoleRepository.findById(3).get();
            manager.setEmployeeRole(employeeRole);
            employeeRepository.save(manager);
        }
        if (!employeeRepository.findByUsername("hongduc").isPresent()) {
            Employee manager = new Employee();
            manager.setUsername("HongDuc");
            manager.setPassword(passwordEncoder.encode("123456"));
            manager.setAddress("Quảng Nam");
            manager.setCreatedAt(new Date(new Date().getTime()));
            manager.setEmail("hongduc@gmail.com");
            manager.setName("Le Hong Duc");
            manager.setPhone("0934567890");
            EmployeeRole employeeRole = employeeRoleRepository.findById(3).get();
            manager.setEmployeeRole(employeeRole);
            employeeRepository.save(manager);
        }
        if (!employeeRepository.findByUsername("ngoctung").isPresent()) {
            Employee manager = new Employee();
            manager.setUsername("ngoctung");
            manager.setPassword(passwordEncoder.encode("123456"));
            manager.setAddress("Quảng Nam");
            manager.setCreatedAt(new Date(new Date().getTime()));
            manager.setEmail("thanhson@gmail.com");
            manager.setName("Ngọc Tùng");
            manager.setPhone("0834567890");
            EmployeeRole employeeRole = employeeRoleRepository.findById(2).get();
            manager.setEmployeeRole(employeeRole);
            employeeRepository.save(manager);
        }

        // create new brand
        if (brandRepository.findById(1).isEmpty()) {
            Brand brand = new Brand();
            brand.setId(1);
            brand.setName("SamSum");
            brandRepository.save(brand);
        }
        if (brandRepository.findById(2).isEmpty()) {
            Brand brand = new Brand();
            brand.setId(2);
            brand.setName("Casino");
            brandRepository.save(brand);
        }
        if (brandRepository.findById(3).isEmpty()) {
            Brand brand = new Brand();
            brand.setId(3);
            brand.setName("Oppo");
            brandRepository.save(brand);
        }
        if (brandRepository.findById(4).isEmpty()) {
            Brand brand = new Brand();
            brand.setId(4);
            brand.setName("Adidas");
            brandRepository.save(brand);
        }
        if (brandRepository.findById(5).isEmpty()) {
            Brand brand = new Brand();
            brand.setId(5);
            brand.setName("Men");
            brandRepository.save(brand);
        }
        if (brandRepository.findById(6).isEmpty()) {
            Brand brand = new Brand();
            brand.setId(6);
            brand.setName("Sony");
            brandRepository.save(brand);
        }

        // create new category
        if (categoryRepository.findById(1).isEmpty()) {
            Category category = new Category();
            category.setId(1);
            category.setName("Điện thoại và phụ kiện");
            categoryRepository.save(category);
        }
        if (categoryRepository.findById(2).isEmpty()) {
            Category category = new Category();
            category.setId(2);
            category.setName("Thời trang nam");
            categoryRepository.save(category);
        }
        if (categoryRepository.findById(3).isEmpty()) {
            Category category = new Category();
            category.setId(3);
            category.setName("Thiết bị điện tử");
            categoryRepository.save(category);
        }
        if (categoryRepository.findById(4).isEmpty()) {
            Category category = new Category();
            category.setId(4);
            category.setName("Ðồng hồ");
            categoryRepository.save(category);
        }
        if (categoryRepository.findById(5).isEmpty()) {
            Category category = new Category();
            category.setId(5);
            category.setName("Giày dép");
            categoryRepository.save(category);
        }

        // create new user
        if (userRepository.findById(1).isEmpty()) {
            User user = new User();
            user.setId(1);
            user.setAddress("Đà Nẵng");
            user.setName("Hồng Đức");
            user.setEmail("user1@gmail.com");
            user.setUsername("hongduc");
            user.setPassword(passwordEncoder.encode("123456"));
            user.setPhone("0868964424");
            user.setCreatedAt(new Date(new Date().getTime()));
            userRepository.save(user);
        }
        if (userRepository.findById(2).isEmpty()) {
            User user = new User();
            user.setId(2);
            user.setAddress("Quảng Nam");
            user.setName("Tuấn");
            user.setEmail("user2@gmail.com");
            user.setUsername("user2");
            user.setPassword(passwordEncoder.encode("123456"));
            user.setPhone("0868965434");
            user.setCreatedAt(new Date(new Date().getTime()));
            userRepository.save(user);
        }
        if (userRepository.findById(3).isEmpty()) {
            User user = new User();
            user.setId(3);
            user.setAddress("Huế");
            user.setName("Duy");
            user.setEmail("user1@gmail.com");
            user.setUsername("user3");
            user.setPassword(passwordEncoder.encode("123456"));
            user.setPhone("0868962224");
            user.setCreatedAt(new Date(new Date().getTime()));
            userRepository.save(user);
        }
        if (userRepository.findById(4).isEmpty()) {
            User user = new User();
            user.setId(4);
            user.setAddress("Hà Nội");
            user.setName("Hoa");
            user.setEmail("user1@gmail.com");
            user.setUsername("user4");
            user.setPassword(passwordEncoder.encode("123456"));
            user.setPhone("0868964424");
            user.setCreatedAt(new Date(new Date().getTime()));
            userRepository.save(user);
        }
        if (userRepository.findById(5).isEmpty()) {
            User user = new User();
            user.setId(5);
            user.setAddress("Hồ Chí Minh");
            user.setName("Đào");
            user.setEmail("user5@gmail.com");
            user.setUsername("daont");
            user.setPassword(passwordEncoder.encode("123456"));
            user.setPhone("0868955214");
            user.setCreatedAt(new Date(new Date().getTime()));
            userRepository.save(user);
        }
        // create new shopRole
        if (shopRoleRepository.findById(1).isEmpty()) {
            ShopRole shopRole = new ShopRole();
            shopRole.setId(1);
            shopRole.setRoleName("Chủ cửa hàng");
            shopRoleRepository.save(shopRole);
        }
        if (shopRoleRepository.findById(2).isEmpty()) {
            ShopRole shopRole = new ShopRole();
            shopRole.setId(2);
            shopRole.setRoleName("Quản lí");
            shopRoleRepository.save(shopRole);
        }
        if (shopRoleRepository.findById(3).isEmpty()) {
            ShopRole shopRole = new ShopRole();
            shopRole.setId(3);
            shopRole.setRoleName("Nhân viên");
            shopRoleRepository.save(shopRole);
        }
        // create new recipient
        if (recipientRepository.findById(1).isEmpty()) {
            Recipient recipient = new Recipient();
            recipient.setId(1);
            recipient.setAddress("Huế");
            recipient.setEmail("user2@gmail.com");
            recipient.setName("Duy");
            recipient.setPhone("0868975578");
            User user = userRepository.findById(3).get();
            recipient.setUser(user);
            recipientRepository.save(recipient);
        }
        if (recipientRepository.findById(2).isEmpty()) {
            Recipient recipient = new Recipient();
            recipient.setId(2);
            recipient.setAddress("Hà Nội");
            recipient.setEmail("user4@gmail.com");
            recipient.setName("Hoa");
            recipient.setPhone("0868974478");
            User user = userRepository.findById(4).get();
            recipient.setUser(user);
            recipientRepository.save(recipient);
        }
        if (recipientRepository.findById(3).isEmpty()) {
            Recipient recipient = new Recipient();
            recipient.setId(3);
            recipient.setAddress("Huế");
            recipient.setEmail("user2@gmail.com");
            recipient.setName("Duy");
            recipient.setPhone("0868975578");
            User user = userRepository.findById(3).get();
            recipient.setUser(user);
            recipientRepository.save(recipient);
        }
        if (recipientRepository.findById(4).isEmpty()) {
            Recipient recipient = new Recipient();
            recipient.setId(4);
            recipient.setAddress("Hà Nội");
            recipient.setEmail("user4@gmail.com");
            recipient.setName("Hoa");
            recipient.setPhone("0868974478");
            User user = userRepository.findById(4).get();
            recipient.setUser(user);
            recipientRepository.save(recipient);
        }
        if (recipientRepository.findById(5).isEmpty()) {
            Recipient recipient = new Recipient();
            recipient.setId(5);
            recipient.setAddress("Hồ Chí Minh");
            recipient.setEmail("user5@gmail.com");
            recipient.setName("Đào");
            recipient.setPhone("0868975222");
            User user = userRepository.findById(5).get();
            recipient.setUser(user);
            recipientRepository.save(recipient);
        }
        // create new shopPack
        if (shopPackRepository.findById(1).isEmpty()) {
            ShopPack shopPack = new ShopPack();
            shopPack.setId(1);
            shopPack.setName("Cá Nhân");
            shopPack.setPrice(Float.valueOf(0));
            shopPackRepository.save(shopPack);
        }
        if (shopPackRepository.findById(2).isEmpty()) {
            ShopPack shopPack = new ShopPack();
            shopPack.setId(2);
            shopPack.setName("Chuyên Nghiệp");
            shopPack.setPrice(Float.valueOf(100000));
            shopPackRepository.save(shopPack);
        }
        if (shopPackRepository.findById(3).isEmpty()) {
            ShopPack shopPack = new ShopPack();
            shopPack.setId(3);
            shopPack.setName("VIP");
            shopPack.setPrice(Float.valueOf(500000));
            shopPackRepository.save(shopPack);
        }
        // create new shop
        if (shopRepository.findById(1).isEmpty()) {
            Shop shop = new Shop();
            if (userRepository.findById(1).isPresent()) {
                shop.setId(1);
                shop.setAddress("Đà Nẵng");
                shop.setCreatedAt(new Date(new Date().getTime()));
                shop.setEmail("shop1@gmail.com");
                shop.setName("D&D");
                shop.setPhone("0905741863");
                shop.setStatus("ok");
                ShopPack shopPack = shopPackRepository.findById(1).get();
                shop.setShopPack(shopPack);
                shopRepository.save(shop);
            }

        }
        if (shopRepository.findById(2).isEmpty()) {
            Shop shop = new Shop();
            if (userRepository.findById(2).isPresent()) {
                shop.setId(2);
                shop.setAddress("Quảng Nam");
                shop.setCreatedAt(new Date(new Date().getTime()));
                shop.setEmail("shop2@gmail.com");
                shop.setName("FPT");
                shop.setPhone("0905741562");
                shop.setStatus("ok");
                ShopPack shopPack = shopPackRepository.findById(3).get();
                shop.setShopPack(shopPack);
                shopRepository.save(shop);
            }

        }
        if (shopRepository.findById(3).isEmpty()) {
            Shop shop = new Shop();
            if (userRepository.findById(3).isPresent()) {
                shop.setId(3);
                shop.setAddress("Huế");
                shop.setCreatedAt(new Date(new Date().getTime()));
                shop.setEmail("shop3@gmail.com");
                shop.setName("PPP");
                shop.setPhone("0905321458");
                shop.setStatus("ok");
                ShopPack shopPack = shopPackRepository.findById(2).get();
                shop.setShopPack(shopPack);
                shopRepository.save(shop);
            }

        }
        if (shopRepository.findById(4).isEmpty()) {
            Shop shop = new Shop();
            if (userRepository.findById(4).isPresent()) {
                shop.setId(4);
                shop.setAddress("Hà Nội");
                shop.setCreatedAt(new Date(new Date().getTime()));
                shop.setEmail("shop4@gmail.com");
                shop.setName("Luxury");
                shop.setPhone("0905741863");
                shop.setStatus("ok");
                ShopPack shopPack = shopPackRepository.findById(2).get();
                shop.setShopPack(shopPack);
                shopRepository.save(shop);
            }

        }
        if (shopRepository.findById(5).isEmpty()) {
            Shop shop = new Shop();
            if (userRepository.findById(5).isPresent()) {
                shop.setId(5);
                shop.setAddress("Hồ Chí Minh");
                shop.setCreatedAt(new Date(new Date().getTime()));
                shop.setEmail("shop5@gmail.com");
                shop.setName("1994");
                shop.setPhone("0905741741");
                shop.setStatus("ok");
                ShopPack shopPack = shopPackRepository.findById(2).get();
                shop.setShopPack(shopPack);
                shopRepository.save(shop);
            }

        }
        // create new shopEmployee
        if (shopEmployeeRepository.findById(1).isEmpty()) {
            ShopEmployee shopEmployee = new ShopEmployee();
            shopEmployee.setId(1);
            Shop shop = shopRepository.findById(1).get();
            shopEmployee.setShop(shop);
            ShopRole shopRole = shopRoleRepository.findById(1).get();
            shopEmployee.setShopRole(shopRole);
            User user = userRepository.findById(1).get();
            shopEmployee.setUser(user);
            shopEmployeeRepository.save(shopEmployee);
        }
        if (shopEmployeeRepository.findById(2).isEmpty()) {
            ShopEmployee shopEmployee = new ShopEmployee();
            shopEmployee.setId(2);
            Shop shop = shopRepository.findById(2).get();
            shopEmployee.setShop(shop);
            ShopRole shopRole = shopRoleRepository.findById(2).get();
            shopEmployee.setShopRole(shopRole);
            User user = userRepository.findById(2).get();
            shopEmployee.setUser(user);
            shopEmployeeRepository.save(shopEmployee);
        }
        if (shopEmployeeRepository.findById(3).isEmpty()) {
            ShopEmployee shopEmployee = new ShopEmployee();
            shopEmployee.setId(3);
            Shop shop = shopRepository.findById(3).get();
            shopEmployee.setShop(shop);
            ShopRole shopRole = shopRoleRepository.findById(2).get();
            shopEmployee.setShopRole(shopRole);
            User user = userRepository.findById(3).get();
            shopEmployee.setUser(user);
            shopEmployeeRepository.save(shopEmployee);
        }
        if (shopEmployeeRepository.findById(4).isEmpty()) {
            ShopEmployee shopEmployee = new ShopEmployee();
            shopEmployee.setId(4);
            Shop shop = shopRepository.findById(4).get();
            shopEmployee.setShop(shop);
            ShopRole shopRole = shopRoleRepository.findById(1).get();
            shopEmployee.setShopRole(shopRole);
            User user = userRepository.findById(4).get();
            shopEmployee.setUser(user);
            shopEmployeeRepository.save(shopEmployee);
        }
        if (shopEmployeeRepository.findById(5).isEmpty()) {
            ShopEmployee shopEmployee = new ShopEmployee();
            shopEmployee.setId(5);
            Shop shop = shopRepository.findById(5).get();
            shopEmployee.setShop(shop);
            ShopRole shopRole = shopRoleRepository.findById(2).get();
            shopEmployee.setShopRole(shopRole);
            User user = userRepository.findById(5).get();
            shopEmployee.setUser(user);
            shopEmployeeRepository.save(shopEmployee);
        }
        // create new product
        if (productRepository.findById(1).isEmpty()) {
            Product product = new Product();
            product.setId(1);
            product.setName("Điện thoại SamSum");
            product.setStatus("ok");
            product.setDes("Điện Thoại SamSum chính hãng");
            Brand brand = brandRepository.findById(1).get();
            product.setBrand(brand);
            Category category = categoryRepository.findById(2).get();
            product.setCategory(category);
            Employee empolyee = employeeRepository.findById(2).get();
            product.setEmpolyee(empolyee);
            productRepository.save(product);
        }
        if (productRepository.findById(2).isEmpty()) {
            Product product = new Product();
            product.setId(2);
            product.setName("Đồng hồ ");
            product.setStatus("ok");
            product.setDes("Điện thoại oppo chính hãng");
            Brand brand = brandRepository.findById(2).get();
            product.setBrand(brand);
            Category category = categoryRepository.findById(3).get();
            product.setCategory(category);
            Employee empolyee = employeeRepository.findById(1).get();
            product.setEmpolyee(empolyee);
            productRepository.save(product);
        }
        if (productRepository.findById(3).isEmpty()) {
            Product product = new Product();
            product.setId(3);
            product.setName("Điện Thoại OPPO");
            product.setStatus("oke");
            product.setDes("Điện thoại oppo chính hãng");
            Brand brand = brandRepository.findById(3).get();
            product.setBrand(brand);
            Category category = categoryRepository.findById(1).get();
            product.setCategory(category);
            Employee empolyee = employeeRepository.findById(1).get();
            product.setEmpolyee(empolyee);
            productRepository.save(product);
        }
        if (productRepository.findById(4).isEmpty()) {
            Product product = new Product();
            product.setId(4);
            product.setName("Quần Short");
            product.setStatus("oke");
            product.setDes("Quần short nam");
            Brand brand = brandRepository.findById(4).get();
            product.setBrand(brand);
            Category category = categoryRepository.findById(2).get();
            product.setCategory(category);
            Employee empolyee = employeeRepository.findById(2).get();
            product.setEmpolyee(empolyee);
            productRepository.save(product);
        }
        if (productRepository.findById(5).isEmpty()) {
            Product product = new Product();
            product.setId(5);
            product.setName("Tai Nghe");
            product.setStatus("oke");
            product.setDes("Tai nghe sony");
            Brand brand = brandRepository.findById(6).get();
            product.setBrand(brand);
            Category category = categoryRepository.findById(1).get();
            product.setCategory(category);
            Employee empolyee = employeeRepository.findById(1).get();
            product.setEmpolyee(empolyee);
            productRepository.save(product);
        }
        if (productRepository.findById(6).isEmpty()) {
            Product product = new Product();
            product.setId(6);
            product.setName("Loa");
            product.setStatus("oke");
            product.setDes("Loa sony");
            Brand brand = brandRepository.findById(6).get();
            product.setBrand(brand);
            Category category = categoryRepository.findById(3).get();
            product.setCategory(category);
            Employee empolyee = employeeRepository.findById(1).get();
            product.setEmpolyee(empolyee);
            productRepository.save(product);
        }
        if (productRepository.findById(7).isEmpty()) {
            Product product = new Product();
            product.setId(7);
            product.setName("Tivi");
            product.setStatus("oke");
            product.setDes("Tivi sony");
            Brand brand = brandRepository.findById(6).get();
            product.setBrand(brand);
            Category category = categoryRepository.findById(3).get();
            product.setCategory(category);
            Employee empolyee = employeeRepository.findById(4).get();
            product.setEmpolyee(empolyee);
            productRepository.save(product);
        }
        if (productRepository.findById(8).isEmpty()) {
            Product product = new Product();
            product.setId(8);
            product.setName("Giày");
            product.setStatus("oke");
            product.setDes("Giày Men");
            Brand brand = brandRepository.findById(5).get();
            product.setBrand(brand);
            Category category = categoryRepository.findById(5).get();
            product.setCategory(category);
            Employee empolyee = employeeRepository.findById(2).get();
            product.setEmpolyee(empolyee);
            productRepository.save(product);
        }
        if (productRepository.findById(9).isEmpty()) {
            Product product = new Product();
            product.setId(9);
            product.setName("Nón");
            product.setStatus("oke");
            product.setDes("Nón Adidas");
            Brand brand = brandRepository.findById(4).get();
            product.setBrand(brand);
            Category category = categoryRepository.findById(2).get();
            product.setCategory(category);
            Employee empolyee = employeeRepository.findById(2).get();
            product.setEmpolyee(empolyee);
            productRepository.save(product);
        }
        if (productRepository.findById(10).isEmpty()) {
            Product product = new Product();
            product.setId(10);
            product.setName("Áo Thun");
            product.setStatus("oke");
            product.setDes("Áo Adidas");
            Brand brand = brandRepository.findById(4).get();
            product.setBrand(brand);
            Category category = categoryRepository.findById(2).get();
            product.setCategory(category);
            Employee empolyee = employeeRepository.findById(2).get();
            product.setEmpolyee(empolyee);
            productRepository.save(product);
        }
        // create new shopItem
        if (shopItemRepository.findById(1).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(1);
            shopItem.setDes("Thiết kế đẹp mắt");
            shopItem.setPrice(Float.valueOf(4990000));
            shopItem.setQuantity(100);
            shopItem.setTitle("SamSum Galaxy A51");
            Product product = productRepository.findById(1).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(2).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(2).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(2);
            shopItem.setDes("SamSum j7 pro");
            shopItem.setPrice(Float.valueOf(6700000));
            shopItem.setQuantity(100);
            shopItem.setTitle("Thiết kế đẹp mắt");
            Product product = productRepository.findById(2).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(3).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }
        if (shopItemRepository.findById(3).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(3);
            shopItem.setDes("Thiết kế đẹp mắt");
            shopItem.setPrice(Float.valueOf(10850000));
            shopItem.setQuantity(100);
            shopItem.setTitle("SamSum Note 10+");
            Product product = productRepository.findById(2).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(2).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }
        if (shopItemRepository.findById(4).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(4);
            shopItem.setDes("Mang phong cách cổ điển");
            shopItem.setPrice(Float.valueOf(269000));
            shopItem.setQuantity(100);
            shopItem.setTitle("Đồng hồ Casino F91W-1DG");
            Product product = productRepository.findById(2).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(2).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }
        if (shopItemRepository.findById(5).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(5);
            shopItem.setDes("Sản phẩm huyền thoại");
            shopItem.setPrice(Float.valueOf(1460000));
            shopItem.setQuantity(19);
            shopItem.setTitle("Đồng hồ Casio AE-1200WHD-1AVDF");
            Product product = productRepository.findById(2).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(3).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }
        if (shopItemRepository.findById(6).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(6);
            shopItem.setDes("Khả năng chống nước ở độ sâu 50 mét");
            shopItem.setPrice(Float.valueOf(517000));
            shopItem.setQuantity(100);
            shopItem.setTitle("Đồng hồ nam dây nhựa Casio MW-240-3BVDF");
            Product product = productRepository.findById(2).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(5).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }
        if (shopItemRepository.findById(7).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(7);
            shopItem.setDes("Thiết kế cao cấp");
            shopItem.setPrice(Float.valueOf(6490000));
            shopItem.setQuantity(10);
            shopItem.setTitle("Ðiện thoại OPPO A92");
            Product product = productRepository.findById(3).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(2).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }
        if (shopItemRepository.findById(8).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(8);
            shopItem.setDes("Thiết kế mới, hiện đại và ấn tượng");
            shopItem.setPrice(Float.valueOf(8490000));
            shopItem.setQuantity(10);
            shopItem.setTitle("Ðiện thoại OPPO Reno4");
            Product product = productRepository.findById(3).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(3).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }
        if (shopItemRepository.findById(9).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(9);
            shopItem.setDes("Thiết kế bắt mắt");
            shopItem.setPrice(Float.valueOf(2690000));
            shopItem.setQuantity(10);
            shopItem.setTitle("Ðiện thoại OPPO A1K");
            Product product = productRepository.findById(3).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(5).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }
        if (shopItemRepository.findById(10).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(10);
            shopItem.setDes("Quần được may với chất liệu jean dày loại tốt");
            shopItem.setPrice(Float.valueOf(320000));
            shopItem.setQuantity(100);
            shopItem.setTitle("Quần short nam");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(1).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }
        if (shopItemRepository.findById(11).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(11);
            shopItem.setDes("Đầy đủ size và màu");
            shopItem.setPrice(Float.valueOf(300000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Quần short nam");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(3).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }
        if (shopItemRepository.findById(12).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(12);
            shopItem.setDes("Quần thiết kế đứng form chuẩn dáng ");
            shopItem.setPrice(Float.valueOf(100000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Quần short nam đen");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(4).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }
        if (shopItemRepository.findById(13).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(13);
            shopItem.setDes("Áo Hoodies Thời Trang Dành Cho Nam");
            shopItem.setPrice(Float.valueOf(290000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Áo Hoodies Thời Trang Dành Cho Nam");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(4).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(14).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(14);
            shopItem.setDes("Áo Hoodies Có Nón Dài Tay Thời Trang Nam");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Áo Hoodies Có Nón Dài Tay Thời Trang Nam");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(3).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }
        if (shopItemRepository.findById(15).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(15);
            shopItem.setDes("Giầy Chạy bộ Adidas Runfalcon Shoes F36199 Sale Sốc [Rẻ Vô Địch]");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Giầy Chạy bộ Adidas Runfalcon Shoes F36199 Sale Sốc [Rẻ Vô Địch]");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(1).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }
        if (shopItemRepository.findById(16).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(16);
            shopItem.setDes("Giày thể thao nam - MS7 giày sneaker cổ thấp đế cao fom chuẩn mẫu mới nhất");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Giày thể thao nam - MS7 giày sneaker cổ thấp đế cao fom chuẩn mẫu mới nhất");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(2).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }
        if (shopItemRepository.findById(17).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(17);
            shopItem.setDes("Áo giữ nhiệt nữ - Áo giữ nhiệt nữ lót lông hàng đẹp");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Áo giữ nhiệt nữ - Áo giữ nhiệt nữ lót lông hàng đẹp");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(5).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }
        if (shopItemRepository.findById(18).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(18);
            shopItem.setDes("Đồ Bộ Pijama - Bộ lụa satin dài tay hoạ tiết Cao cấp [FREE SHIP]");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Đồ Bộ Pijama - Bộ lụa satin dài tay hoạ tiết Cao cấp [FREE SHIP]");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(5).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }
        if (shopItemRepository.findById(19).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(19);
            shopItem.setDes("Túi Đeo Chéo Canvas Cỡ Lớn Thời Trang Hàn Quốc Học Sinh Sinh Viên Đi Học , Đi Chơi");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Túi Đeo Chéo Canvas Cỡ Lớn Thời Trang Hàn Quốc Học Sinh Sinh Viên Đi Học , Đi Chơi");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(4).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }
        if (shopItemRepository.findById(20).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(20);
            shopItem.setDes("Quần Dài Mỏng Dáng Rộng Kẻ Sọc Thời Trang Mùa Hè Năng Động");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Quần Dài Mỏng Dáng Rộng Kẻ Sọc Thời Trang Mùa Hè Năng Động");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(4).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(21).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(21);
            shopItem.setDes("Áo dài tay DSQ Phản Quang");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Áo dài tay DSQ Phản Quang");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(2).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(22).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(22);
            shopItem.setDes("Mắt Kính Gọng Tròn Phong Cách Retro Cho Nữ");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Mắt Kính Gọng Tròn Phong Cách Retro Cho Nữ");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(2).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(23).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(23);
            shopItem.setDes(
                    "Xả kho để chuẩn bị nhập hàng tết_ Áo sơ mi cao cấp kate lụa dài tay Hàn Quốc _ CỰC CHẤT, số lượng có hạn");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle(
                    "Xả kho để chuẩn bị nhập hàng tết_ Áo sơ mi cao cấp kate lụa dài tay Hàn Quốc _ CỰC CHẤT, số lượng có hạn");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(3).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(24).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(24);
            shopItem.setDes("Phao Gile Hình Cho Bé");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Phao Gile Hình Cho Bé");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(3).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(25).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(25);
            shopItem.setDes(
                    "Xả kho để chuẩn bị nhập hàng tết_ Áo sơ mi cao cấp kate lụa dài tay Hàn Quốc _ CỰC CHẤT, số lượng có hạn");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle(
                    "Xả kho để chuẩn bị nhập hàng tết_ Áo sơ mi cao cấp kate lụa dài tay Hàn Quốc _ CỰC CHẤT, số lượng có hạn");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(3).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(26).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(26);
            shopItem.setDes("KHUNG LƯỚI SẮT TRANG TRÍ SIZE");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("KHUNG LƯỚI SẮT TRANG TRÍ SIZE");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(3).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(27).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(27);
            shopItem.setDes("Giày Bốt Martin Gót Vuông Dày Phong Cách Hàn Quốc Cho Nữ");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Giày Bốt Martin Gót Vuông Dày Phong Cách Hàn Quốc Cho Nữ");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(3).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(28).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(28);
            shopItem.setDes("Quần thể thao nam nỉ dày dặn 3 sọc THE 1992 Jogger 3 lines 508");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Quần thể thao nam nỉ dày dặn 3 sọc THE 1992 Jogger 3 lines 508");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(4).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(29).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(29);
            shopItem.setDes("Áo Sweater Nam Nữ Basic. Áo Nỉ Nam Trơn Unisex Form Rộng Vải Cotton Da Cá Giữ Nhiệt STT1");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle(
                    "Áo Sweater Nam Nữ Basic. Áo Nỉ Nam Trơn Unisex Form Rộng Vải Cotton Da Cá Giữ Nhiệt STT1");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(4).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(30).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(30);
            shopItem.setDes("Áo Len Nam Cổ Cao Hàng Quảng Châu Chất Dày Dặn - AL04");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Áo Len Nam Cổ Cao Hàng Quảng Châu Chất Dày Dặn - AL04");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(4).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(31).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(31);
            shopItem.setDes("Áo Thun Số 10 Baernardo Game Kích Thước S-2Xl Chất Lượng Cao Cho Nam");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Áo Thun Số 10 Baernardo Game Kích Thước S-2Xl Chất Lượng Cao Cho Nam");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(5).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(32).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(32);
            shopItem.setDes("Set quần áo tập thể dục hỗ trợ giảm cân");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Set quần áo tập thể dục hỗ trợ giảm cân");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(5).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(33).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(33);
            shopItem.setDes("Quần ống rộng lưng cao kiều Hàn Quốc");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Quần ống rộng lưng cao kiều Hàn Quốc");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(1).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(34).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(34);
            shopItem.setDes("Áo Thun Nam VNXK Đẹp,Hình Thật Chuẩn Tem Tag.TMoi");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Áo Thun Nam VNXK Đẹp,Hình Thật Chuẩn Tem Tag.TMoi");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(1).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(35).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(35);
            shopItem.setDes("Quần ống rộng lưng cao vải mềm");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Quần ống rộng lưng cao vải mềm");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(1).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(36).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(36);
            shopItem.setDes("Bộ adidas gió");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Bộ adidas gió");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(1).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(37).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(37);
            shopItem.setDes("Quần dài kẻ sọc thời trang QATE302 cho bé trai và bé gái");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Quần dài kẻ sọc thời trang QATE302 cho bé trai và bé gái");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(1).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(38).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(38);
            shopItem.setDes(" ÁO KHOÁC KAKI JEAN NAM ĐẸP THỜI TRANG MỚI NHẤT 2019 KKN01");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle(" ÁO KHOÁC KAKI JEAN NAM ĐẸP THỜI TRANG MỚI NHẤT 2019 KKN01");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(1).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(39).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(39);
            shopItem.setDes(" Son kem lì Merzy The First Velvet Tint");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle(" Son kem lì Merzy The First Velvet Tint");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(2).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        if (shopItemRepository.findById(40).isEmpty()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(40);
            shopItem.setDes(" Áo giữ nhiệt nam thể thao dài tay nhiều màu size từ 45 đến 90kg AT28");
            shopItem.setPrice(Float.valueOf(390000));
            shopItem.setQuantity(12);
            shopItem.setTitle("Áo giữ nhiệt nam thể thao dài tay nhiều màu size từ 45 đến 90kg AT28");
            Product product = productRepository.findById(4).get();
            shopItem.setProduct(product);
            Shop shop = shopRepository.findById(2).get();
            shopItem.setShop(shop);
            shopItemRepository.save(shopItem);
        }

        // create new cartDetail
        if (cartDetailRepository.findById(1).isEmpty()) {
            CartDetail cartDetail = new CartDetail();
            cartDetail.setId(1);
            cartDetail.setQuantity(3);
            ShopItem shopItem = shopItemRepository.findById(2).get();
            cartDetail.setShopItem(shopItem);
            User user = userRepository.findById(1).get();
            cartDetail.setUser(user);
            cartDetailRepository.save(cartDetail);
        }
        if (cartDetailRepository.findById(2).isEmpty()) {
            CartDetail cartDetail = new CartDetail();
            cartDetail.setId(2);
            cartDetail.setQuantity(3);
            ShopItem shopItem = shopItemRepository.findById(4).get();
            cartDetail.setShopItem(shopItem);
            User user = userRepository.findById(2).get();
            cartDetail.setUser(user);
            cartDetailRepository.save(cartDetail);
        }
        if (cartDetailRepository.findById(3).isEmpty()) {
            CartDetail cartDetail = new CartDetail();
            cartDetail.setId(3);
            cartDetail.setQuantity(3);
            ShopItem shopItem = shopItemRepository.findById(7).get();
            cartDetail.setShopItem(shopItem);
            User user = userRepository.findById(3).get();
            cartDetail.setUser(user);
            cartDetailRepository.save(cartDetail);
        }
        if (cartDetailRepository.findById(4).isEmpty()) {
            CartDetail cartDetail = new CartDetail();
            cartDetail.setId(4);
            cartDetail.setQuantity(3);
            ShopItem shopItem = shopItemRepository.findById(8).get();
            cartDetail.setShopItem(shopItem);
            User user = userRepository.findById(4).get();
            cartDetail.setUser(user);
            cartDetailRepository.save(cartDetail);
        }
        if (cartDetailRepository.findById(5).isEmpty()) {
            CartDetail cartDetail = new CartDetail();
            cartDetail.setId(5);
            cartDetail.setQuantity(3);
            ShopItem shopItem = shopItemRepository.findById(11).get();
            cartDetail.setShopItem(shopItem);
            User user = userRepository.findById(5).get();
            cartDetail.setUser(user);
            cartDetailRepository.save(cartDetail);
        }

        // create new orderStatus
        if (orderStatusRepository.findById(1).isEmpty()) {
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setId(1);
            orderStatus.setStatusName("Chờ xác nhận");
            orderStatusRepository.save(orderStatus);
        }
        if (orderStatusRepository.findById(2).isEmpty()) {
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setId(2);
            orderStatus.setStatusName("Chờ lấy hàng");
            orderStatusRepository.save(orderStatus);
        }
        if (orderStatusRepository.findById(3).isEmpty()) {
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setId(3);
            orderStatus.setStatusName("Đang giao");
            orderStatusRepository.save(orderStatus);
        }
        if (orderStatusRepository.findById(4).isEmpty()) {
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setId(4);
            orderStatus.setStatusName("Đã giao");
            orderStatusRepository.save(orderStatus);
        }
        if (orderStatusRepository.findById(5).isEmpty()) {
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setId(5);
            orderStatus.setStatusName("Đã hủy");
            orderStatusRepository.save(orderStatus);
        }

        // create new order
        if (orderRepostitory.findById(1).isEmpty()) {
            Order order = new Order();
            order.setId(1);
            order.setDate(new Date(new Date().getTime()));
            User user = userRepository.findById(1).get();
            order.setUser(user);
            OrderStatus orderStatus = orderStatusRepository.findById(1).get();
            order.setOrderStatus(orderStatus);
            Recipient recipient = recipientRepository.findById(3).get();
            order.setRecipient(recipient);
            orderRepostitory.save(order);
        }
        if (orderRepostitory.findById(2).isEmpty()) {
            Order order = new Order();
            order.setId(2);
            order.setDate(new Date(new Date().getTime()));
            User user = userRepository.findById(2).get();
            order.setUser(user);
            OrderStatus orderStatus = orderStatusRepository.findById(2).get();
            order.setOrderStatus(orderStatus);
            Recipient recipient = recipientRepository.findById(4).get();
            order.setRecipient(recipient);
            orderRepostitory.save(order);
        }
        if (orderRepostitory.findById(3).isEmpty()) {
            Order order = new Order();
            order.setId(3);
            order.setDate(new Date(new Date().getTime()));
            User user = userRepository.findById(3).get();
            order.setUser(user);
            OrderStatus orderStatus = orderStatusRepository.findById(3).get();
            order.setOrderStatus(orderStatus);
            Recipient recipient = recipientRepository.findById(3).get();
            order.setRecipient(recipient);
            orderRepostitory.save(order);
        }
        if (orderRepostitory.findById(4).isEmpty()) {
            Order order = new Order();
            order.setId(4);
            order.setDate(new Date(new Date().getTime()));
            User user = userRepository.findById(4).get();
            order.setUser(user);
            OrderStatus orderStatus = orderStatusRepository.findById(4).get();
            order.setOrderStatus(orderStatus);
            Recipient recipient = recipientRepository.findById(4).get();
            order.setRecipient(recipient);
            orderRepostitory.save(order);
        }
        if (orderRepostitory.findById(5).isEmpty()) {
            Order order = new Order();
            order.setId(5);
            order.setDate(new Date(new Date().getTime()));
            User user = userRepository.findById(5).get();
            order.setUser(user);
            OrderStatus orderStatus = orderStatusRepository.findById(5).get();
            order.setOrderStatus(orderStatus);
            Recipient recipient = recipientRepository.findById(5).get();
            order.setRecipient(recipient);
            orderRepostitory.save(order);
        }

        // create new orderDetail
        if (orderDetailRepostitory.findById(1).isEmpty()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setId(1);
            orderDetail.setPrice(Float.valueOf(4490000));
            orderDetail.setQuantity(1);
            ShopItem shopItem = shopItemRepository.findById(1).get();
            orderDetail.setShopItem(shopItem);
            Order order = orderRepostitory.findById(1).get();
            orderDetail.setOrder(order);
            orderDetailRepostitory.save(orderDetail);
        }
        if (orderDetailRepostitory.findById(2).isEmpty()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setId(2);
            orderDetail.setPrice(Float.valueOf(6700000));
            orderDetail.setQuantity(10);
            ShopItem shopItem = shopItemRepository.findById(2).get();
            orderDetail.setShopItem(shopItem);
            Order order = orderRepostitory.findById(2).get();
            orderDetail.setOrder(order);
            orderDetailRepostitory.save(orderDetail);
        }
        if (orderDetailRepostitory.findById(3).isEmpty()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setId(3);
            orderDetail.setPrice(Float.valueOf(269000));
            orderDetail.setQuantity(10);
            ShopItem shopItem = shopItemRepository.findById(4).get();
            orderDetail.setShopItem(shopItem);
            Order order = orderRepostitory.findById(3).get();
            orderDetail.setOrder(order);
            orderDetailRepostitory.save(orderDetail);
        }
        if (orderDetailRepostitory.findById(4).isEmpty()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setId(4);
            orderDetail.setPrice(Float.valueOf(517000));
            orderDetail.setQuantity(10);
            ShopItem shopItem = shopItemRepository.findById(6).get();
            orderDetail.setShopItem(shopItem);
            Order order = orderRepostitory.findById(4).get();
            orderDetail.setOrder(order);
            orderDetailRepostitory.save(orderDetail);
        }
        if (orderDetailRepostitory.findById(1).isEmpty()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setId(1);
            orderDetail.setPrice(Float.valueOf(1460000));
            orderDetail.setQuantity(10);
            ShopItem shopItem = shopItemRepository.findById(5).get();
            orderDetail.setShopItem(shopItem);
            Order order = orderRepostitory.findById(5).get();
            orderDetail.setOrder(order);
            orderDetailRepostitory.save(orderDetail);
        }

    }

}
