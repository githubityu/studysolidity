package com.ityu.soliditystudy

import com.ityu.*
import com.ityu.util.*
import org.web3j.abi.datatypes.Address
import org.web3j.abi.datatypes.Bool
import org.web3j.abi.datatypes.DynamicArray
import org.web3j.abi.datatypes.Utf8String
import org.web3j.abi.datatypes.generated.Int256
import org.web3j.abi.datatypes.generated.Uint256
import org.web3j.tx.FastRawTransactionManager
import org.web3j.tx.ReadonlyTransactionManager
import org.web3j.tx.gas.DefaultGasProvider
import org.web3j.tx.gas.StaticGasProvider
import org.web3j.utils.Convert
import org.web3j.utils.Numeric
import java.math.BigInteger


fun main() {

    //e7cca1246f31d9aa849dc05882ba07eac8f4243b5d0af26456cb2b057c126387-30a0
    //b05d79f5f9605a2f8156475856677fa5feef8d1c6a4105842984e4a60955e6df
    //c917844d5f8ab4ca595e626ce218c5275eec689f2b2072fe793ea53ee88b25ce
    //186b16258a979cf597edebadbaf2e6d5ac65e5ab4197d5cfc7ff4c301ca9ab13-4fff
    //72ed99b5bd194431f98e04e89e8b69f8cd00888018019ac071455ae6bf4ee030-1c53
    val web3j = getWeb3j()
//    CatalystApp.load("0xfc03B569e381145fC3e3bDE5EbCCa272378475c8",web3j,ReadonlyTransactionManager(web3j,"0x630959E5aE57D1165c29B5aDC2F77C2bB8B730a0"),DefaultGasProvider())
   var cre = getCre("72ed99b5bd194431f98e04e89e8b69f8cd00888018019ac071455ae6bf4ee030")

    // val dcl = DCLRegistrar.load("0x335a66abb1f73099b5b8b173b70c14d29646ef24", web3j,cre,getSimpleGasPrice(web3j.ethGasPrice().send().gasPrice),BigInteger("8000000"))
      //val hash =  dcl.register("ityu2","0x630959E5aE57D1165c29B5aDC2F77C2bB8B730a0").send().transactionHash
    //val hash =  dcl.addController("0x630959E5aE57D1165c29B5aDC2F77C2bB8B730a0").send().transactionHash

   // print(hash)
   val staticGasProvider =  StaticGasProvider(getSimpleGasPrice(web3j.ethGasPrice().send().gasPrice),BigInteger("8000000"))

    //"PMDreamverseEminence":"0xc2909fedc1977d074c34a1e58d605a25356dc8b6",
    //"MLLiondance":"0xd26182b37d5b838f5462df1c9d6058a59a0ea59a",
    //"DCNiftyblocksmith":"0x1a594433bc7e31b12dff4b0e71876047bf4184f3",
    //"MemeDontBuyThis":"0x9666b0933114351ef830f38e3aa5b75ee0ae3e00",
    //"DappcraftMoonminerCollection":"0x3c3028fd7df516cd67d6ad261951a2c2aed63172",
    //"CybermikeCyberSoldier":"  0xa394642abd1a6786f0cebe84140352ee7c9a26f4",
    //"DCGCollection":" 0x952532c4aba00ed1cc3e82248a394b3f1c85eb46",
    //"WonderzoneMeteorchaserCollection":" 0x279bfd22d64e03e4b0f24e65d8002d79425543fa",
    //"TechTribalMarc0matic":" 0xa1aa39a7467374e1c5ff700fccda7f9ffd9d0383",
    //"-----------"未初始化数据"->,"0x1742525e081385C24F793319166DddFdB9602BE9
    //"AtariLaunch":"0xde11aee1b6b9ac3948d174fb05731f506a5d4fee",
    //"EtheremonWearables":"0xf6a30aee0461094a65692e8da64bd2d225a8515b",
    //"DgtbleHeadspaceCollection":"0x5d96c3b1e1c83a044064dd898379aebc50042370",
    //"DigitalAlchemy":"0x2c25fc989ca3b24a15ee56bb228d8e9605d3e3e9",
    //"WZWonderbot":"0xa9fadcd033cb648283b665ef78efdd309fdfd4fa",
    //"MLPekingopera":"0x85eeef30a38ab3cf3e508e254218cfdd7f3312de",
    //"RACBasics":"0x3d4e497d61183ad4c4eba7f40281068d9f5a0e83",
    //"Moonshot2020Collection":"0x5bc6e0355e2e9f1393b1d6842b1c44e9bb642151",
    //"RTFKTXAtari":"0xf7d756aebe1f08e89bdfc281521f1f67e6bae3d8",
    //"DGFall2020":"0xe82f9e99cee13d7ff3398798703f8ec5cdc14bb4",
    //"PMOuttathisworldCollection":"0x6c29b1141c72d24abb7a60fd0712705485215865",
    //"ChinaFlying":"0x05556eba48fd9b3f0ce9b34199787e174b5d044a",
    //"BinanceUsCollection":"0xdc221459f74fc0222d20335b1119aa1c607c5a09",
    //"SugarclubYumi":"0x45ef8a4fd17c8a9567d54356af5f8ddcda7d1534",
    //"WonderzoneSteampunk":"0x46ad1e92d13d9c184612f76ed57b8b1272cf4483",
    //"DGSummer2020Collection":"0x77c99b78a708ae674216fc6ed5855c45c98c131f",
    //"ExclusiveMasksCollection":"0xf20cdef35a83277735aff591cdcba0badefed6ef",
    //"Halloween2019Collection":"0x1573ef902cf7d2942c2c725d95c0dec6a52fe090",
    //"Xmas2019Collection":"0x02c870f12751df12e0c9183166147146f5be0a8e",
    //"CZMercenaryMTZ":"0x5eb867d12fd1bb5e4d573149f17cfff6cf3044e3",
    //"WinklevossCapital":"0xf9a9eb795c4c99e29713011bf02176529979bd77",
    //"XmashUp2020":"0x5b1cb6684b7264f5737597cc310c0f537880f864",
    //"3LAUBasics":"0xbfe0c6bf435686448423c542155510c441b91c1f",
    //"Xmas2020Collection":"0x120207c867d9fadab4283bf8935076bca7bad56f",
    //"MCHCollection":"0x49adf2f35a1efb418162286ccf414452a21f360b",
    //"DCMeta":"0x874417659b0fe13f0cd3315a3cba155a829dd657",
    //"Halloween2020Collection":"0x99cd4374a96e0eba3d30a618f849ba6ae37b0ed5",
    //"ReleaseTheKraken":"0x86ac66e204f04eb179bf3412d362ce2ea625e3b6",
    //"MFSammichgamer":"0xa4a111ad30f96c3e344b0b8637e138e697cd9b0a", 待初始化1c53
    //"StaySafeCollection":"0x6a417853016c5751ffe07c590a4d3aa454fd5fcd",
    //"CommunityContestCollection":"0x5e5ff2f0b52fee29e0aed8fbac82b8e88b89821b",
    //"DCLLaunchCollection":"0x9a82eddb662b9005d9f51341ca38a3e8e6f616d3",
    //"ClaimWearableForFree":"0xa1d2be87790c90744a03ea94f0e37620832f2862",

 //   deployErc721("dcl://dcg_collection","DCLDCGCLLCTN","https://wearable-api.decentraland.org/v2/standards/erc721-metadata/collections/dcg_collection/wearables/".trim(),web3j,cre,staticGasProvider)

//    val wearableIds = mutableListOf(
//        "0x6d665f66726f6766696e73000000000000000000000000000000000000000000".stringToBytes(),
//        "0x6d665f77696e67736e65616b6572730000000000000000000000000000000000".stringToBytes(),
//        "0x6d665f616e696d65686169720000000000000000000000000000000000000000".stringToBytes(),
//        "0x6d665f756e69636f726e68656c6d657400000000000000000000000000000000".stringToBytes(),
//        "0x6d665f756e69636f726e70616e74730000000000000000000000000000000000".stringToBytes(),
//        "0x6d665f73616d6d696368746f72736f0000000000000000000000000000000000".stringToBytes(),
//
//    )
//    val maxIssuances = mutableListOf(
//        BigInteger("100"),
//        BigInteger("100"),
//        BigInteger("100"),
//        BigInteger("100"),
//        BigInteger("100"),
//        BigInteger("100"),
//    )
//
//    addWearables("0xa4a111ad30f96c3e344b0b8637e138e697cd9b0a",web3j,cre,staticGasProvider,wearableIds,maxIssuances)

//        while (true){
//            Thread.sleep(50000)
//            testGetRop("")
//        }

    val mutableList  = mutableListOf(
        "0xc2909fedc1977d074c34a1e58d605a25356dc8b6",
        "0xd26182b37d5b838f5462df1c9d6058a59a0ea59a",
        "0x1a594433bc7e31b12dff4b0e71876047bf4184f3",
        "0x9666b0933114351ef830f38e3aa5b75ee0ae3e00",
        "0x3c3028fd7df516cd67d6ad261951a2c2aed63172",
        "0xa394642abd1a6786f0cebe84140352ee7c9a26f4",
        "0x952532c4aba00ed1cc3e82248a394b3f1c85eb46",
        "0x279bfd22d64e03e4b0f24e65d8002d79425543fa",
        "0xa1aa39a7467374e1c5ff700fccda7f9ffd9d0383",
        "0xde11aee1b6b9ac3948d174fb05731f506a5d4fee",
        "0xf6a30aee0461094a65692e8da64bd2d225a8515b",
        "0x5d96c3b1e1c83a044064dd898379aebc50042370",
        "0x2c25fc989ca3b24a15ee56bb228d8e9605d3e3e9",
        "0xa9fadcd033cb648283b665ef78efdd309fdfd4fa",
        "0x85eeef30a38ab3cf3e508e254218cfdd7f3312de",
        "0x3d4e497d61183ad4c4eba7f40281068d9f5a0e83",
        "0x5bc6e0355e2e9f1393b1d6842b1c44e9bb642151",
        "0xf7d756aebe1f08e89bdfc281521f1f67e6bae3d8",
        "0xe82f9e99cee13d7ff3398798703f8ec5cdc14bb4",
        "0x6c29b1141c72d24abb7a60fd0712705485215865",
        "0x05556eba48fd9b3f0ce9b34199787e174b5d044a",
        "0xdc221459f74fc0222d20335b1119aa1c607c5a09",
        "0x45ef8a4fd17c8a9567d54356af5f8ddcda7d1534",
        "0x46ad1e92d13d9c184612f76ed57b8b1272cf4483",
        "0x77c99b78a708ae674216fc6ed5855c45c98c131f",
        "0xf20cdef35a83277735aff591cdcba0badefed6ef",
        "0x1573ef902cf7d2942c2c725d95c0dec6a52fe090",
        "0x02c870f12751df12e0c9183166147146f5be0a8e",
        "0x5eb867d12fd1bb5e4d573149f17cfff6cf3044e3",
        "0xf9a9eb795c4c99e29713011bf02176529979bd77",
        "0x5b1cb6684b7264f5737597cc310c0f537880f864",
        "0xbfe0c6bf435686448423c542155510c441b91c1f",
        "0x120207c867d9fadab4283bf8935076bca7bad56f",
        "0x49adf2f35a1efb418162286ccf414452a21f360b",
        "0x874417659b0fe13f0cd3315a3cba155a829dd657",
        "0x99cd4374a96e0eba3d30a618f849ba6ae37b0ed5",
        "0x86ac66e204f04eb179bf3412d362ce2ea625e3b6",
        "0xa4a111ad30f96c3e344b0b8637e138e697cd9b0a",
        "0x6a417853016c5751ffe07c590a4d3aa454fd5fcd",
        "0x5e5ff2f0b52fee29e0aed8fbac82b8e88b89821b",
        "0x9a82eddb662b9005d9f51341ca38a3e8e6f616d3",
    )
//    var names = ""
//    mutableList.forEach {
//        val name = ERC721Collection.load(it, web3j, cre, staticGasProvider).name().send().toString()
//        names = names.plus(name).plus(",")
//        Thread.sleep(2000)
//
//    }
    //val name = ERC721Collection.load("0xa1d2be87790c90744a03ea94f0e37620832f2862", web3j, cre, staticGasProvider).name().send().toString()
   // println(names)
   // replaceNonce("72ed99b5bd194431f98e04e89e8b69f8cd00888018019ac071455ae6bf4ee030","1","0x1742525e081385C24F793319166DddFdB9602BE9")

    val test = "dcl://pm_dreamverse_eminence,dcl://ml_liondance,dcl://dc_niftyblocksmith,dcl://meme_dontbuythis,dcl://dappcraft_moonminer,dcl://cybermike_cybersoldier_set,dcl://dcg_collection,dcl://wonderzone_meteorchaser,dcl://tech_tribal_marc0matic,dcl://atari_launch,dcl://ethermon_wearables,dcl://dgtble_headspace,dcl://digital_alchemy,dcl://wz_wonderbot,dcl://ml_pekingopera,dcl://rac_basics,dcl://moonshot_2020,dcl://rtfkt_x_atari,dcl://dg_fall_2020,dcl://pm_outtathisworld,dcl://china_flying,dcl://binance_us_collection,dcl://sugarclub_yumi,dcl://wonderzone_steampunk,dcl://dg_summer_2020,dcl://exclusive_masks,dcl://halloween_2019,dcl://xmas_2019,dcl://cz_mercenary_mtz,dcl://winklevoss_capital,dcl://xmash_up_2020,dcl://3lau_basics,dcl://xmas_2020,dcl://mch_collection,dcl://dc_meta,dcl://halloween_2020,dcl://release_the_kraken,dcl://mf_sammichgamer,dcl://stay_safe,dcl://community_contest,dcl://dcl_launch"

    val split = test.split(",")
    val list = JsonUtil.fromJsonAsList(Any::class.java, getJsonString())
//    list .forEach {
//        val linkedHashMap = it as LinkedHashMap<*, *>
//        val name =  linkedHashMap["name"].toString()
//         if(split.contains(name)){
//             println(name)
//         }
//    }

    println(split.size)
    println(list.size)



}


