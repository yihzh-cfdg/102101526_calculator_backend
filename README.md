# 软件工程第二次作业——基于vue+Springboot的前后端交互计算器

学号：102101526 	姓名：易华章

[toc]

## 作业基本信息

| 这个作业属于哪个课程 | [2301-计算机学院-软件工程](https://bbs.csdn.net/forums/ssynkqtd-05) |
| :------------------- | :----------------------------------------------------------- |
| 这个作业要求在哪里   | [第二次作业--前后端交互计算器](https://bbs.csdn.net/topics/617377308) |
| 这个作业的目标       | 实现更完善的计算器功能，使用任意可视化技术实现一个前后端分离的计算器 |
| 其他参考文献         | [vue帮助文档](https://v2.cn.vuejs.org/)、[springboot帮助文档](https://docs.spring.io/spring-boot/docs/current/reference/html/index.html) |




## Github项目地址

[102101526_calculator_frontend](https://github.com/yihzh-cfdg/102101526_calculator_frontend)

[102101526_calculator_backend](https://github.com/yihzh-cfdg/102101526_calculator_backend)



## PSP表格

| PSP                                     | Personal Software Process Stages        | 预估耗时（分钟） | 实际耗时（分钟） |
| :-------------------------------------- | :-------------------------------------- | :--------------- | :--------------- |
| **Planning**                            | **计划**                                | **30**           | **30**           |
| • Estimate                              | • 估计这个任务需要多少时间              | 30               | 30               |
| **Development**                         | **开发**                                | **3260**         | **3650**         |
| • Analysis                              | • 需求分析 (包括学习新技术）            | 1500             | 1800~            |
| • Design Spec                           | • 生成设计文档                          | 30               | 30               |
| • Design Review                         | • 设计复审                              | 10               | 10               |
| • Coding Standard                       | • 代码规范 (为目前的开发制定合适的规范) | 10               | 10               |
| • Design                                | • 具体设计                              | 120              | 180              |
| • Coding                                | • 具体编码                              | 1440             | 1500             |
| • Code Review                           | • 代码复审                              | 120              | 60               |
| • Test                                  | • 测试（自我测试，修改代码，提交修改）  | 30               | 60               |
| **Reporting**                           | **报告**                                | **30**           | **60**           |
| • Test Repor                            | • 测试报告                              | 10               | 10               |
| • Size Measurement                      | • 计算工作量                            | 10               | 10               |
| • Postmortem & Process Improvement Plan | • 事后总结, 并提出过程改进计划          | 10               | 40               |
|                                         | **合计**                                | **3320**         | **3740**         |



## 成品展示

### 基础计算器功能

#### 功能1：加减乘除、取余、括号运算

实现了基本的加减乘除、括号匹配。

![](img/1.gif)

![](img/1-2.gif)

#### 功能2：清零回退

![](img/2.gif)

#### 功能3：错误提示

遇到错误时会锁定所有按钮（除了CE），并且在结果栏显示错误提示。

![](img/3.gif)

#### 功能4：读取历史记录

按下“ANS”，从上一次计算记录中取结果。

![](img/4.gif)

#### 附加功能1：科学计算器

实现了一些基本的函数

![](img/5.gif)

#### 附加功能2：页面原型设计

![](img/6-1.png)

![](img/6-2.png)

#### 其他附加功能

​	上次Python计算器里面有的附加功能，这次我也在网页端实现了，有很多小细节的功能：

- [x] 算出结果之后再按等号可以循环做最后一次运算
- [x] 算出结果之后立马可以进行下一次运算，不用按CE
- [x] 已有符号的表达式可以随意更换符号
- [x] 分成两栏，上栏显示当前的表达式，下栏显示实时的运算结果
- [x] 在碰到`5*=`这种输入的时候会变成`5*5=`，避免了错误
- [x] 自动匹配括号
- [x] 应用函数时只对下栏的运算结果生效，间接维护了运算符号顺序
- [x] 拥有像电子计算器的`shift`键，可以在布局中切换不同函数
- [x] 错误处理和异常情况处理
- [x] 历史记录功能

顺便把上次项目没做的历史记录和括号匹配也给补全了。

#### 项目部署

前端通过Nginx部署在81端口，后端部署在服务器后台。

[102101526-calculator-frontend](http://47.110.148.166:81/#/calculator)



### 利率计算器功能

![](img/7-0.png)

#### 功能1：计算存款、贷款利息

选择定期存款时时长是选择框，选择活期存款可以自由输入时长。

![](img/7.gif)

#### 扩展功能：前端修改存贷款利息

实现了基础的增删改查：

![](img/8.gif)

#### 扩展功能：输入验证（有点基础，但是好像也能算扩展）

在两个input上加了原生的onkeyup函数，通过正则表达式限制输入，金额只能输入最多带六位小数的数字，时长只能输入最多带两位小数的数字。

![](img/9.gif)



## 设计实现过程

​	这次看到要设计一个前后端分离的计算器，第一时间想到的就是去学大名鼎鼎的spring+vue，但是没想到前置知识这么多，还好ddl延长了一周，不然连javaweb都学不完。好在学会之后，感觉非常简便非常好用。代码风格参考了阿里的Java开发手册。

### 项目设计

这个项目被我分为6个部分：

1. 分析题目，列出学习要求，在本次作业中是ssm和vue
2. 学习相关技术
3. 分析需求，包括需要的接口、支持的功能、需要的数据库表等
4. 在原型设计软件中设计软件原型
5. 实现程序代码+debug
6. 写blog

实际上做起来还是非常赶（肝），前面偷懒，这几天爆肝把代码写完了。

这次毕竟是学了框架的，画了张MVC的类图：

![](img/类图.png)

​	前端通过axios联系后端，后端中的Controller负责收发调度，Service负责具体的业务逻辑实现，Mapper负责数据库的数据访问。

### 代码实现

#### 前端

使用Vue+ElementUI进行前端开发，用Axios和后端通信。

**科学计算器**

*html*

```html
<template>
  <div>
    <el-container>
      <el-aside width="10%"></el-aside>
      <el-aside width="20%">
        <el-table :data="tableData" style="width: 100%">
          <el-table-column prop="exps" label="历史记录"></el-table-column>
        </el-table>
      </el-aside>
      <el-main width="800px">
        <div class="back" style="box-shadow: 10px 8px 15px">
          <div class="side-text">
            <p class="side-exp">{{ old_exp }}</p>
          </div>
          <div class="main-text">
            <template v-if="true">
              <p class="main-exp">{{ currentVal }}</p>
            </template>
            <template v-else>
              <p class="main-exp">0</p>
            </template>
          </div>
          <div>
            <el-row class="keys">
              <el-button :disabled="isDisabled" class="shift" @click="onShiftClick">
                shift
              </el-button>
              <el-button :disabled="isDisabled" id="pi" class="func" @click="clickHandler($event)">
                π
              </el-button>
              <el-button :disabled="isDisabled" class="func" @click="getAns">ANS</el-button>
              <el-button id="ce" class="func" @click="clickHandler($event)">CE</el-button>
              <el-button :disabled="isDisabled" id="del" class="func" @click="clickHandler($event)">
                ←
              </el-button>
            </el-row>
            ...(下面都是一样的按钮)
          </div>
        </div>
      </el-main>
    </el-container>
  </div>
</template>
```

*css*

```css
<style lang="less" scoped>
.back {
  background-color: rgb(243, 243, 243);
  width: 600px;
  height: 800px;
  position: relative;
}
.side-text {
  position: absolute;
  left: 15px;
  top: 75px;
  width: 575px;
  height: 82px;
  color: rgba(154, 154, 154, 1);
  font-size: 24px;
  font-family: SourceHanSansSC-regular;
  .side-exp {
    position: absolute;
    margin: auto; /* 添加自动外边距 */
    right: 0; /* 添加右边距为零 */
    bottom: 0; /* 添加底边距为零 */
  }
}
.main-text {
  position: absolute;
  left: 15px;
  top: 171px;
  width: 575px;
  height: 89px;
  color: rgba(16, 16, 16, 1);
  font-size: 72px;
  font-family: SourceHanSansSC-regular;
  .main-exp {
    text-align: right;
    vertical-align: bottom;
    height: 89px; /* 设置 <p> 元素的高度 */
    line-height: 89px; /* 设置 <p> 元素的行高 */
  }
}
.keys {
  top: 277px;
  margin-bottom: 7px;
  &:last-child {
    margin-bottom: 0;
  }
  .func {
    width: 110px;
    height: 68px;
    border-radius: 4px;
    background-color: rgba(249, 249, 249, 1);
    color: rgba(16, 16, 16, 1);
    font-size: 28px;
    text-align: center;
    box-shadow: 1px 1px 1px -4px rgba(0, 0, 0, 0.4);
    font-family: Roboto;
    border: 1px solid rgba(187, 187, 187, 1);
    &:hover {
      background-color: rgb(246, 246, 246);
    }
    &:active {
      background-color: rgb(244, 244, 244);
      color: rgb(100, 100, 100);
    }
  }
  .num {
    width: 110px;
    height: 68px;
    border-radius: 4px;
    background-color: rgba(255, 255, 255, 1);
    color: rgba(16, 16, 16, 1);
    font-size: 28px;
    text-align: center;
    box-shadow: 1px 1px 1px -4px rgba(0, 0, 0, 0.4);
    font-family: Roboto;
    border: 1px solid rgba(187, 187, 187, 1);
    &:hover {
      background-color: rgb(249, 249, 249);
    }
    &:active {
      background-color: rgb(247, 247, 247);
      color: rgb(120, 120, 120);
    }
  }
  .shift {
    width: 110px;
    height: 68px;
    border-radius: 4px;
    background-color: rgba(249, 249, 249, 1);
    color: rgba(89, 27, 183, 1);
    font-size: 28px;
    text-align: center;
    box-shadow: 1px 1px 1px -4px rgba(0, 0, 0, 0.4);
    font-family: Roboto;
    border: 1px solid rgba(187, 187, 187, 1);
    &:hover {
      background-color: rgb(246, 246, 246);
      color: #591bb7;
    }
    &:active {
      background-color: rgb(247, 247, 247);
      color: #8359c2;
    }
  }
  .equ {
    width: 110px;
    height: 68px;
    border-radius: 4px;
    background-color: rgba(89, 27, 183, 1);
    color: rgba(255, 255, 255, 1);
    font-size: 28px;
    text-align: center;
    box-shadow: 1px 1px 1px -4px rgba(0, 0, 0, 0.4);
    font-family: Roboto;
    border: 1px solid rgba(187, 187, 187, 1);
    &:hover {
      background-color: rgb(80, 20, 170);
      color: rgb(255, 255, 255);
    }
    &:active {
      background-color: rgb(70, 10, 160);
      color: rgb(255, 255, 255);
    }
  }
}
</style>
```

用了特别多elementui的组件，写的特别丑。用key、func、num等类来调整样式。

学了less语法，确实比原生css好用一点。

*js(ts)*

```typescript
<script>
import axios from "axios";
export default {
  name: "calculator",
  mounted() {
    this.$nextTick(function () {
      this.getHistory();
    });
  },
  methods: {
    clickHandler(e) {
      let that = this;
      let target = e.target;
      if (target.nodeName == "SPAN") {
        target = e.target.parentNode;
        target.blur();
      }
      let button_text = target.id;
      console.log(target.id);
      // impl
      if (that.isNum(button_text)) {
        if (!that.noPrev) that.remake();
        if (button_text === "0" && that.isEmpty()) return;
        if (that.changeOp) that.changeOp = false;
        that.new_exp += button_text;
        try {
          that.currentVal = eval(this.new_exp);
        } catch (error) {
          this.errorHandler(error);
          return;
        }
      } else if (that.isSym(button_text)) {
        if (that.dot && that.new_exp.slice(-1) == ".") that.new_exp = "0";
        if (that.changeOp) {
          that.old_exp = that.old_exp.substring(0, that.old_exp.length - 1);
          that.old_exp += button_text;
        } else if (!that.noPrev) {
          that.noPrev = true;
          that.changeOp = true;
          that.new_exp = "";
          that.old_exp = that.currentVal.toString() + button_text;
        } else {
          if (that.isEmpty()) that.old_exp = "0";
          else that.old_exp += that.new_exp;
          that.new_exp = "";
          if (!this.bracket)
            try {
              that.lastVal = that.currentVal;
              that.currentVal = eval(that.old_exp);
            } catch (error) {
              this.errorHandler("等式错误");
              return;
            }
          that.old_exp += button_text;
          that.changeOp = true;
        }
      } else if (button_text === "=") {
        if (that.bracket != 0) this.errorHandler("括号不匹配");
        if (!that.noPrev) {
          that.old_exp = that.currentVal.toString();
          that.old_exp += that.holdVal;
          try {
            that.currentVal = eval(that.old_exp);
          } catch (error) {
            this.errorHandler("等式错误");
            return;
          }
          that.old_exp += "=";
        } else if (that.changeOp) {
          that.changeOp = false;
          that.noPrev = false;
          that.holdVal += that.old_exp.slice(-1);
          that.old_exp += that.currentVal.toString();
          try {
            that.currentVal = eval(that.old_exp);
          } catch (error) {
            this.errorHandler("等式错误");
            return;
          }
          that.holdVal += that.currentVal.toString();
          that.old_exp += "=";
        } else {
          that.noPrev = false;
          if (that.old_exp != "") {
            that.holdVal = that.old_exp.slice(-1) + that.new_exp;
            that.old_exp += that.new_exp;
          } else {
            that.holdVal = "";
            that.old_exp = that.new_exp;
            if (that.isEmpty()) that.old_exp = "0";
          }
          try {
            that.currentVal = eval(that.old_exp);
          } catch (error) {
            this.errorHandler(error);
            return;
          }
          that.old_exp += "=";
        }
        that.setHistory(that.old_exp + that.currentVal);
      } else if (button_text == "inv" && that.currentVal != 0) {
        that.currentVal = -that.currentVal;
        if (that.inv == false) {
          that.new_exp = "-" + that.new_exp;
          that.inv = true;
        } else {
          that.new_exp = that.new_exp.substring(1);
          that.inv = false;
        }
      } else if (button_text == ".") {
        if (!that.dot) {
          if (that.currentVal == 0) that.new_exp = "0";
          that.dot = true;
          that.new_exp += ".";
          that.currentVal = that.new_exp;
        }
      } else if (target.className === "el-button func el-button--default") {
        that.funcHandler(button_text);
      }
    },
    getAns() {
      let that = this;
      let pattern = /(?<==)[0-9.-]+/;
      if (that.tableData.length > 0) {
        that.currentVal = eval(that.tableData[0].exps.match(pattern)[0]);
        that.inv = that.currentVal < 0;
        that.new_exp = that.currentVal.toString();
      }
    },
    funcHandler(button_text) {
        ...
      // 和clickHandler一样，非常长，就不放进去了
    },
    errorHandler(e) {
      this.currentVal = "错误：" + e;
      this.isDisabled = true;
    },
    onShiftClick() {
      this.shift = !this.shift;
    },
    setHistory(history) {
      axios
        .post("/api/cal/setHistory", { exps: history })
        .then((response) => {
          console.log(response);
          this.getHistory();
        })
        .catch((error) => {
          console.error("Set history error", error);
        });
    },
    getHistory() {
      axios
        .get("/api/cal/getHistory")
        .then((response) => {
          this.tableData = response.data.data;
        })
        .catch((error) => {
          console.error("Get history error", error);
        });
    },
    remake() {
      let that = this;
      that.old_exp = "";
      that.new_exp = "";
      that.holdVal = "";
      that.currentVal = 0;
      that.lastVal = 0;
      that.dot = false;
      that.changeOp = false;
      that.inv = false;
      that.noPrev = true;
      that.bracket = 0;
      that.isDisabled = false;
    },
    isNum(val) {
      let pattern = /^[0-9]*$/;
      return pattern.test(val);
    },
    isSym(val) {
      return ["+", "-", "*", "/", "%"].indexOf(val) != -1;
    },
    isEmpty() {
      return this.currentVal === 0 && this.new_exp === "";
    },
    degToRad(deg) {
      return Math.PI * 2 * (deg / 360);
    },
  },
  data() {
    return {
      ...
    };
  },
};
</script>

```

主要完成一个计算功能，对于每一个输入都更新输出值。

**利率计算器**

用了el-container布局，其实就是表格+表格+表单。

```html
<el-container>
    <el-aside width="400px" style="margin-left: 160px">
     <el-table :data="tableData1" stripe>
         ...
     </el-table>
    </el-aside>
    <el-aside width="400px" style="margin-left: 50px">
     <el-table :data="tableData2" stripe>
         ...
     </el-table>
    </el-aside>
    <el-aside style="width: 420px; height: 600px">
      <el-form>
         ...
      </el-form>
    </el-aside>
  </el-container>
</template>
```

js代码就不放上来了，也和科学计算器差不多。。。

#### 后端

##### 科学计算器

这次计算器还是做的挺不错：

- 功能齐全
- 看起来像个计算器
- 还原原型设计

​	但是有个问题就是前后端分的不是很离，一开始我认为前后端分离是前端只负责页面展示，把所有请求都发到后端，让后端计算，但是这一次由于时间匆忙，没时间从头在Java里面造eval()的轮子，只好使用js自带的eval()了。所以我这是前端前台渲染+后台计算+后端处理数据，也算是前后端分离了，刚开始还觉得怪不好意思的，后面问了老师+看大伙好像都是这样做的，那就顺其自然吧。

使用SpringBoot框架开发，数据访问用了MyBatis。把所有的精力都放到业务逻辑实现，写的特别爽。

定义了一些类：

- xxxBean，实体类
- xxxMapper：接口，利用注解定义方法，自动装填成bean
- xxxService：接口，用于定义各种服务，这次作业里面有`CalculatorService`和`RateCalculatorService`
- xxxServiceImpl：对应接口的实现类
- xxxController：控制器类，定义暴露给前端的接口，并收发请求，调用Service执行业务。

后端主要负责历史记录管理：

**CalculatorController**

```java
@RestController
@CrossOrigin
@RequestMapping("/api/cal")
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    @Deprecated
    @PostMapping("/getResult")
    public Double funcHandler(@RequestBody ResultData data){
        return calculatorService.funcHandler(data);
    }

    @PostMapping("/setHistory")
    public Result<String> setHistory(@RequestBody History history){
        int res = calculatorService.setHistory(history);
        return Result.success("Success Insert " + res);
    }
    @ResponseBody
    @GetMapping("/getHistory")
    public List<History> sendHistory(){
        return calculatorService.getHistory();
    }
}

```

定义了/api/cal/接口，让前端通过ajax请求访问。

**CalculatorServiceImpl**、

```java
@Service("calculatorService")
public class CalculatorServiceImpl implements CalculatorService {
    @Autowired
    private HistoryMapper historyMapper;

    @Deprecated
    @Override
    public Double funcHandler(ResultData resultData) {...}

    @Override
    public List<History> getHistory() {
        return historyMapper.selectTop10();
    }

    @Override
    public int setHistory(History history) {
        return historyMapper.insert(history);
    }
}
```

实现业务逻辑，本来还想在后端完成函数计算的，由于时间不够作罢，留下了funcHandler这个类，标成弃用，希望以后有机会再完善。。

**HistoryMapper**

```java
@Mapper
public interface HistoryMapper{
    @Select("SELECT * FROM history ORDER BY hno DESC LIMIT 10;\n")
    List<History> selectTop10();

    @Delete("delete from history")
    int deleteAll();

    @Insert("insert into history values(null, #{exps}) ")
    int insert(History history);
}

```

实现数据访问操作。

##### 利率计算器

```java
@RestController
@CrossOrigin
@RequestMapping("/api/rate")
public class RateCalculatorController {
    @Autowired
    RateCalculatorService rateCalculatorService;
    @ResponseBody
    @GetMapping("/getDeposit")
    public List<Deposit> sendAllDeposit()
    {
        List<Deposit> a = rateCalculatorService.getAllDeposit();
       return a;
    }
    @ResponseBody
    @GetMapping("/getLoan")
    public List<Loan> sendAllLoan()
    {
        return rateCalculatorService.getAllLoan();
    }
    @PostMapping("/updateLoan")
    public Result<String> setLoan(@RequestBody Loan loan)
    {
        int res = rateCalculatorService.updateLoan(loan);
        return Result.success("Success set "+ res);
    }
    @PostMapping("/updateDeposit")
    public Result<String> setDeposit(@RequestBody Deposit deposit)
    {
        int res = rateCalculatorService.updateDeposit(deposit);
        return Result.success("Success set "+ res);
    }
    @PostMapping("/delLoan")
    public Result<String> delLoan(@RequestBody Loan loan)
    {
        int res = rateCalculatorService.deleteLoan(loan);
        return Result.success("Success del "+ res);
    }
    @PostMapping("/delDeposit")
    public Result<String> delDeposit(@RequestBody Deposit deposit)
    {
        int res = rateCalculatorService.deleteDeposit(deposit);
        return Result.success("Success del "+ res);
    }
    @ResponseBody
    @PostMapping("/insertDeposit")
    public Result<String> insertDeposit(@RequestBody Deposit deposit)
    {
        int res = rateCalculatorService.insertDeposit(deposit);
        return Result.success("Success insert "+ res);
    }
    @ResponseBody
    @PostMapping("/insertLoan")
    public Result<String> insertDeposit(@RequestBody Loan loan)
    {
        int res = rateCalculatorService.insertLoan(loan);
        return Result.success("Success insert "+ res);
    }
}

```

同样也是CURD，不再赘述。

##### Controller层处理

**统一返回结构**

定义返回的数据格式

```java
public interface IResult {
    Integer getCode();

    String getMessage();
}
```

定义枚举

```java
@Getter
public enum ResultEnum implements IResult {

    SUCCESS(2001, "接口调用成功"),
    VALIDATE_FAILED(2002, "参数校验失败"),
    COMMON_FAILED(2003, "接口调用失败"),
    FORBIDDEN(2004, "没有权限访问资源");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
```

定义Result类

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;
    public static <T> Result<T> success(T data) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }
    public static <T> Result<T> success(String message, T data) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), message, data);
    }
    public static Result<?> failed() {
        return new Result<>(ResultEnum.COMMON_FAILED.getCode(), ResultEnum.COMMON_FAILED.getMessage(), null);
    }
    public static Result<?> failed(String message) {
        return new Result<>(ResultEnum.COMMON_FAILED.getCode(), message, null);
    }
    public static Result<?> failed(IResult errorResult) {
        return new Result<>(errorResult.getCode(), errorResult.getMessage(), null);
    }
    public static <T> Result<T> instance(Integer code, String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
```

这样一来，后端返回的就是统一封装好的`Result`，方便前端知道这个接口的调用是否成功。



## 心路历程和收获

1、这两周的学习历程大概就是**痛**并**快乐**着，一方面这两周事情很多，考试很多，还要抽出时间来学框架，非常痛苦，另一方面，又感觉自己学会了一点点东西，能把这个计算器写完真的是出乎我的意料，整个过程充满了bug。某一天调spring一个识别不到bean的bug花了三个小时。。。也说明框架好用的前提就是要搞懂框架的原理，搞懂怎么用。最后一周学了springboot，发现还有三天就要交作业了，赶紧从零开始把计算器码出来，也熬了不少夜。但是不得不说用了框架写代码是真爽，不用再去考虑大部分的细节，只要把每个功能实现完就好，加个注解就能搞定很多操作。也让我知道了低耦合度的好处，有时候加一个功能只要实现一个方法就好了，根本不用去改别的地方的代码。

2、这两周ava的学习路线：vue->JavaWeb->MyBatis->Spring->SpringMVC->Springboot，看这些课花了大概二十个小时，但是很多东西都是不求甚解，不去考虑实现原理，直接看使用方法。所以后面还是要再去学一遍，把实现的原理给搞懂。

3、这次前后端分离真是直切痛点，这是我第一次从零开始做前后端，让我搞懂了一点之前最不会的前后端接口设计，也让我知道了我被ddl压迫时的学习能力。最后，No pain no gain，希望之后我还能保持这种学习热情，还能做得更好。
