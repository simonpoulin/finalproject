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
import fpt.java.finalproject.models.ProductImage;
import fpt.java.finalproject.models.Recipient;
import fpt.java.finalproject.models.Shop;
import fpt.java.finalproject.models.ShopEmployee;
import fpt.java.finalproject.models.ShopItem;
import fpt.java.finalproject.models.ShopItemImage;
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
import fpt.java.finalproject.repositories.ProductImageRepository;
import fpt.java.finalproject.repositories.ProductRepository;
import fpt.java.finalproject.repositories.RecipientRepository;
import fpt.java.finalproject.repositories.ShopEmployeeRepository;
import fpt.java.finalproject.repositories.ShopItemImageRepository;
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

    @Autowired
    ShopItemImageRepository shopItemImageRepository;

    @Autowired
    ProductImageRepository productImageRepository;

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
        if (employeeRepository.findByUsername("admin1") == null) {
            Employee admin = new Employee();
            admin.setUsername("admin1");
            admin.setPassword(passwordEncoder.encode("123456"));
            admin.setAddress("Đà Nẵng");
            admin.setCreatedAt(new Date(new Date().getTime()));
            admin.setEmail("admin1@gmail.com");
            admin.setName("Duy");
            admin.setPhone("0868741852");
            EmployeeRole employeeRole = employeeRoleRepository.findById(3).get();
            admin.setEmployeeRole(employeeRole);
            employeeRepository.save(admin);
        }

        // Manager account
        if (employeeRepository.findByUsername("admin2") == null) {
            Employee manager = new Employee();
            manager.setUsername("admin2");
            manager.setPassword(passwordEncoder.encode("admin123"));
            manager.setAddress("Huế");
            manager.setCreatedAt(new Date(new Date().getTime()));
            manager.setEmail("admin2@gmail.com");
            manager.setName("Nam");
            manager.setPhone("0868748574");
            EmployeeRole employeeRole = employeeRoleRepository.findById(2).get();
            manager.setEmployeeRole(employeeRole);
            employeeRepository.save(manager);
        }

        // Admin account
        if (employeeRepository.findByUsername("admin3") == null) {
            Employee employee = new Employee();
            employee.setUsername("admin3");
            employee.setPassword(passwordEncoder.encode("admin123"));
            employee.setAddress("Quảng Nam");
            employee.setCreatedAt(new Date(new Date().getTime()));
            employee.setEmail("admin3@gmail.com");
            employee.setName("Hoa");
            employee.setPhone("0905147523");
            EmployeeRole employeeRole = employeeRoleRepository.findById(1).get();
            employee.setEmployeeRole(employeeRole);
            employeeRepository.save(employee);
        }
        if (employeeRepository.findByUsername("hongduc") == null) {
            Employee manager = new Employee();
            manager.setUsername("HongDuc");
            manager.setPassword(passwordEncoder.encode("123456"));
            manager.setAddress("Quảng Nam");
            manager.setCreatedAt(new Date(new Date().getTime()));
            manager.setEmail("duc@gmail.com");
            manager.setName("Le Hong Duc");
            manager.setPhone("0934567890");
            EmployeeRole employeeRole = employeeRoleRepository.findById(3).get();
            manager.setEmployeeRole(employeeRole);
            employeeRepository.save(manager);
        }
        if (employeeRepository.findByUsername("thanhson") == null) {
            Employee manager = new Employee();
            manager.setUsername("thanhson");
            manager.setPassword(passwordEncoder.encode("123456"));
            manager.setAddress("Quảng Nam");
            manager.setCreatedAt(new Date(new Date().getTime()));
            manager.setEmail("thanhson@gmail.com");
            manager.setName("Thanh Son");
            manager.setPhone("0834567890");
            EmployeeRole employeeRole = employeeRoleRepository.findById(2).get();
            manager.setEmployeeRole(employeeRole);
            employeeRepository.save(manager);
        }

        // create new brand
        if (brandRepository.findById(1).isEmpty()) {
            Brand brand = new Brand();
            brand.setId(1);
            brand.setBrandName("SamSum");
            brandRepository.save(brand);
        }
        if (brandRepository.findById(2).isEmpty()) {
            Brand brand = new Brand();
            brand.setId(2);
            brand.setBrandName("Casino");
            brandRepository.save(brand);
        }
        if (brandRepository.findById(3).isEmpty()) {
            Brand brand = new Brand();
            brand.setId(3);
            brand.setBrandName("Oppo");
            brandRepository.save(brand);
        }
        if (brandRepository.findById(4).isEmpty()) {
            Brand brand = new Brand();
            brand.setId(4);
            brand.setBrandName("Adidas");
            brandRepository.save(brand);
        }
        if (brandRepository.findById(5).isEmpty()) {
            Brand brand = new Brand();
            brand.setId(5);
            brand.setBrandName("Men");
            brandRepository.save(brand);
        }
        if (brandRepository.findById(6).isEmpty()) {
            Brand brand = new Brand();
            brand.setId(6);
            brand.setBrandName("Sony");
            brandRepository.save(brand);
        }

        // create new category
        if (categoryRepository.findById(1).isEmpty()) {
            Category category = new Category();
            category.setId(1);
            category.setCategoryName("Điện thoại và phụ kiện");
            categoryRepository.save(category);
        }
        if (categoryRepository.findById(2).isEmpty()) {
            Category category = new Category();
            category.setId(2);
            category.setCategoryName("Thời trang nam");
            categoryRepository.save(category);
        }
        if (categoryRepository.findById(3).isEmpty()) {
            Category category = new Category();
            category.setId(3);
            category.setCategoryName("Thiết bị điện tử");
            categoryRepository.save(category);
        }
        if (categoryRepository.findById(4).isEmpty()) {
            Category category = new Category();
            category.setId(4);
            category.setCategoryName("Ðồng hồ");
            categoryRepository.save(category);
        }
        if (categoryRepository.findById(5).isEmpty()) {
            Category category = new Category();
            category.setId(5);
            category.setCategoryName("Giày dép");
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
            recipient.setAddress("Đà Nẵng");
            recipient.setEmail("ABC@gmail.com");
            recipient.setName("Nam");
            recipient.setPhone("0868783254");
            User user = userRepository.findById(1).get();
            recipient.setUser(user);
            recipientRepository.save(recipient);
        }
        if (recipientRepository.findById(2).isEmpty()) {
            Recipient recipient = new Recipient();
            recipient.setId(2);
            recipient.setAddress("Quảng Nam");
            recipient.setEmail("user1@gmail.com");
            recipient.setName("Hà");
            recipient.setPhone("0866763254");
            User user = userRepository.findById(2).get();
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
            Category category = categoryRepository.findById(4).get();
            product.setCategory(category);
            Employee empolyee = employeeRepository.findById(4).get();
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
            Employee empolyee = employeeRepository.findById(2).get();
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
            Employee empolyee = employeeRepository.findById(3).get();
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
            Employee empolyee = employeeRepository.findById(3).get();
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
         // create new productImage
         if (productImageRepository.findById(1).isEmpty()) {
            ProductImage productImage = new ProductImage();
            productImage.setId(1);
            productImage.setImageUrl("");
            Product product = productRepository.findById(1).get();
            productImage.setProduct(product);
            productImageRepository.save(productImage);
        }
        if (productImageRepository.findById(2).isEmpty()) {
            ProductImage productImage = new ProductImage();
            productImage.setId(2);
            productImage.setImageUrl("");
            Product product = productRepository.findById(2).get();
            productImage.setProduct(product);
            productImageRepository.save(productImage);
        }
        if (productImageRepository.findById(3).isEmpty()) {
            ProductImage productImage = new ProductImage();
            productImage.setId(3);
            productImage.setImageUrl("");
            Product product = productRepository.findById(3).get();
            productImage.setProduct(product);
            productImageRepository.save(productImage);
        }
        if (productImageRepository.findById(4).isEmpty()) {
            ProductImage productImage = new ProductImage();
            productImage.setId(4);
            productImage.setImageUrl("");
            Product product = productRepository.findById(4).get();
            productImage.setProduct(product);
            productImageRepository.save(productImage);
        }
        if (productImageRepository.findById(5).isEmpty()) {
            ProductImage productImage = new ProductImage();
            productImage.setId(5);
            productImage.setImageUrl("");
            Product product = productRepository.findById(5).get();
            productImage.setProduct(product);
            productImageRepository.save(productImage);
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

          // create new shopItemImage
          if (shopItemImageRepository.findById(1).isEmpty()) {
            ShopItemImage shopItemImage = new ShopItemImage();
            shopItemImage.setId(1);
            shopItemImage.setImageUrl("s");
            ShopItem shopItem = shopItemRepository.findById(1).get();
            shopItemImage.setShopItem(shopItem);
            shopItemImageRepository.save(shopItemImage);
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
            Recipient recipient = recipientRepository.findById(1).get();
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
            Recipient recipient = recipientRepository.findById(2).get();
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
