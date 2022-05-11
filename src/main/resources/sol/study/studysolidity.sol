// SPDX-License-Identifier: MIT
pragma solidity ^0.8;

/**
* public  internal  private external
* view pure
* address bytes[1-32]
* uint[8-16-32-256]
* 全局变量就是storage需要上链，上链需要gas，上链就是修改storage数据然后发布到链上
* 数组、结构或映射类型 memory calldata 内存中 calldata变量不可变（immutable），一般用于参数 
* xxx[] 可变数组
* xxx[8] 不可变数组
*
*/

interface Api{
    //外部调用
    function func1() external view returns(uint);
}

contract StudySolidity{
    //公开
    uint8 public a = 5;
    //内部公开 和protect类似
    uint8 internal b = 5;
    //对当前合约有效
    uint private c = 5;

    //bytes20
    address token = 0x630959E5aE57D1165c29B5aDC2F77C2bB8B730a0;
    bytes20 token2 = bytes20(0x630959E5aE57D1165c29B5aDC2F77C2bB8B730a0);

    //报错，255不能隐式转换成bytes5 因为byte1 = 
    //bytes5 private d = 0xff;
    //正常255是byte1类型的
    bytes1 private d = 0xff;
    function useApi(Api api) public view returns(uint){
        return api.func1();
    }
    //内部调用
    function func2() internal pure returns(bytes10){
        return 'internal' ;
    }
  
    function funExternal() external pure returns(bytes10){
        return 'external';
    }

      //都能调用
    function func3() public pure returns(bytes10){
        //"funExternal" is not (or not yet) visible at this point
        //return funExternal();
        return  'public';
    }
}

contract StudyA is StudySolidity {
     string private cc = "aaa";
    event HandleResult(string,string,string,string);
    function funA() public  pure  returns(bytes10,bytes10){       
        //正常调用
        return (func3(),func2());
    }

    function getA()  public  view  returns(uint8){
        //都能访问
        return b;
        //return a;
    }

    function testCallData(uint[] calldata a,uint b)  pure public returns(uint[] calldata){
        // Calldata arrays are read-only
        //a[0] = 5;
        b = 10;
        return a;
    }

     function testSM(string memory a)   public {
      // storage=memory
      //创建副本，不影响原来的
        cc = a;
       //memory=memory
       //赋值引用，修改会影响原来的
       string memory dd = a;
       //storage=storage
       //赋值引用，修改会影响原来的
       string storage ee = cc;
       //memory=storage
       //会创建副本，不会影响原来的
       string memory ff = cc;
      emit HandleResult(cc,dd,ee,ff);
    }
   
}