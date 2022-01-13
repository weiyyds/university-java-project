##常用依赖
```xml
 <dependencies>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.1.12.RELEASE</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/junit/junit -->

        <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
        </dependency>

    </dependencies>
```
#注解说明
- @Autowired：自动装配默认通过类型，然后再试名字
   如果Autowired不能唯一自动装配上属性，则通过@Qualifier(value="xxx")
- @nullable:字段标记了这个注解，说明这个字段可以为null；
- @Resource:自动装配默认通过名字，然后再试类型



- @Component:组件,放在类上，说明这个类被spring管理了，就是bean！
- @Value("狂神")：往属性中注入值

#这四个注解的功能是一样的，都是代表某个类注册到spring中，装配bean
- entity：@Component
- dao：@Repository
- service：@Service
- controller：@Controller

