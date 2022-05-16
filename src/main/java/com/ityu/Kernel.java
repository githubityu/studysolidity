package com.ityu;

import io.reactivex.Flowable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.9.0.
 */
@SuppressWarnings("rawtypes")
public class Kernel extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b506040516020806200273e833981016040525180156200003e576200003e64010000000062000045810204565b506200009e565b6200005b6000196401000000006200005d810204565b565b620000977febb05b386a8d34882b8711d156f463690983dc47815980fb82aeeff1aa43579e826401000000006200178f6200009a82021704565b50565b9055565b61269080620000ae6000396000f300608060405260043610620001865763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630803fac081146200018b5780631113ed0d14620001b7578063178e607914620001e157806332f0a3b514620001f9578063397edd41146200022d5780634558850c146200029d578063485cc95514620002bb578063756f604914620002e75780637e7db6e114620002ff57806380cd5ac3146200032357806386070cfe146200034a5780638b3dd74914620003625780638c61757d146200037a5780638ea8dc9d1462000395578063958fde8214620003ad5780639d4941d814620003d4578063ae5b254014620003f8578063be00bbd81462000422578063c050a7a61462000440578063d162f8b014620004b0578063db8a61d4146200051c578063de2873591462000534578063de4796ed146200054c578063e156a8f31462000564578063e8187ff0146200058b578063ede658b014620005a3578063fdef9106146200060f578063ff289fc51462000681575b600080fd5b3480156200019857600080fd5b50620001a3620006a8565b604080519115158252519081900360200190f35b348015620001c457600080fd5b50620001cf620006d6565b60408051918252519081900360200190f35b348015620001ee57600080fd5b50620001cf620006fa565b3480156200020657600080fd5b50620002116200071e565b60408051600160a060020a039092168252519081900360200190f35b3480156200023a57600080fd5b50604080516020600460443581810135601f8101849004840285018401909552848452620002119482359460248035600160a060020a0316953695946064949201919081908401838280828437509497505050509135151592506200075b915050565b348015620002aa57600080fd5b5062000211600435602435620007f1565b348015620002c857600080fd5b50620002e5600160a060020a036004358116906024351662000814565b005b348015620002f457600080fd5b50620001cf62000991565b3480156200030c57600080fd5b50620001a3600160a060020a0360043516620009b5565b3480156200033057600080fd5b5062000211600435600160a060020a0360243516620009bb565b3480156200035757600080fd5b50620001cf62000a10565b3480156200036f57600080fd5b50620001cf62000a16565b3480156200038757600080fd5b50620002e560043562000a48565b348015620003a257600080fd5b50620001cf62000a8b565b348015620003ba57600080fd5b5062000211600435600160a060020a036024351662000a9e565b348015620003e157600080fd5b50620002e5600160a060020a036004351662000aea565b3480156200040557600080fd5b50620002e5600435602435600160a060020a036044351662000e11565b3480156200042f57600080fd5b506200021160043560243562000e41565b3480156200044d57600080fd5b50604080516020600460443581810135601f8101849004840285018401909552848452620002119482359460248035600160a060020a03169536959460649492019190819084018382808284375094975050505091351515925062000e65915050565b348015620004bd57600080fd5b50604080516020600460443581810135601f810184900484028501840190955284845262000211948235600160a060020a031694602480359536959460649492019190819084018382808284375094975062000eb69650505050505050565b3480156200052957600080fd5b50620001cf62000fc1565b3480156200054157600080fd5b506200021162000fd4565b3480156200055957600080fd5b50620001a362001022565b3480156200057157600080fd5b5062000211600160a060020a036004351660243562001037565b3480156200059857600080fd5b50620001cf6200105d565b348015620005b057600080fd5b50604080516020600460443581810135601f810184900484028501840190955284845262000211948235600160a060020a0316946024803595369594606494920191908190840183828082843750949750620010819650505050505050565b3480156200061c57600080fd5b50604080516020601f606435600481810135928301849004840285018401909552818452620001a394600160a060020a0381358116956024803590921695604435953695608494019181908401838280828437509497506200118c9650505050505050565b3480156200068e57600080fd5b5062000211600160a060020a0360043516602435620012cf565b600080620006b562000a16565b90508015801590620006d0575080620006cd620012ee565b10155b91505090565b7f3b4bf6bf3ad5000ecf0f989d5befde585c6860fea3e574a4fab4c49d1c177d9c90565b7fd6f028ca0e8edb4a8c9757ca4fdccab25fa1e0317da1188108f7d2dee14902fb90565b60015460009081527f9e3eae70920eeef6013879bf9155b985893698c145361c31365929723678b2576020526040902054600160a060020a031690565b600060008051602062002625833981519152620007886000805160206200264583398151915287620012f2565b620007a460008051602062002645833981519152888862001300565b620007b130888762001081565b92508315620007e757620007e77fd6f028ca0e8edb4a8c9757ca4fdccab25fa1e0317da1188108f7d2dee14902fb888562000e11565b5050949350505050565b6000602081815292815260408082209093529081522054600160a060020a031681565b600062000820620013e6565b6200085c600080516020620026458339815191527fe3262375f45a6e2026b7e7b18c2b807434f2508fe1a2a3dfb493c7df8f4aad6a8562001424565b62000888307fe3262375f45a6e2026b7e7b18c2b807434f2508fe1a2a3dfb493c7df8f4aad6a62001037565b905080600160a060020a031663c4d66de8836040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018082600160a060020a0316600160a060020a03168152602001915050600060405180830381600087803b158015620008ff57600080fd5b505af115801562000914573d6000803e3d6000fd5b506200096892507fd6f028ca0e8edb4a8c9757ca4fdccab25fa1e0317da1188108f7d2dee14902fb91507fe3262375f45a6e2026b7e7b18c2b807434f2508fe1a2a3dfb493c7df8f4aad6a90508362001424565b50507f7e852e0fcfce6551c13800f1e7476f982525c2b5277ba14b24339c68416336d160015550565b7fc681a85306374a5ab27f0bbc385296a54bcd314a1948b6cf61c4ea1bc44bb9f890565b50600190565b600060008051602062002625833981519152620009e86000805160206200264583398151915285620012f2565b6040805160008082526020820190925262000a0791879187916200075b565b95945050505050565b60015481565b600062000a437febb05b386a8d34882b8711d156f463690983dc47815980fb82aeeff1aa43579e6200154a565b905090565b6000805160206200262583398151915262000a847fd6f028ca0e8edb4a8c9757ca4fdccab25fa1e0317da1188108f7d2dee14902fb83620012f2565b5050600155565b6000805160206200262583398151915281565b60006000805160206200262583398151915262000acb6000805160206200264583398151915285620012f2565b6040805160008082526020820190925262000a07918791879162000e65565b600080600062000afa84620009b5565b60408051808201909152601281527f5245434f5645525f444953414c4c4f5745440000000000000000000000000000602082015290151562000bd7576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825283818151815260200191508051906020019080838360005b8381101562000b9b57818101518382015260200162000b81565b50505050905090810190601f16801562000bc95780820380516001836020036101000a031916815260200191505b509250505060405180910390fd5b5062000be26200071e565b925062000bef836200154e565b60408051808201909152601a81527f5245434f5645525f5641554c545f4e4f545f434f4e5452414354000000000000602082015290151562000c8f576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825283818151815260200191508051906020019080838360008381101562000b9b57818101518382015260200162000b81565b50600160a060020a038416151562000ce35760405130319250600160a060020a0384169083156108fc029084906000818181858888f1935050505015801562000cdc573d6000803e3d6000fd5b5062000dc0565b508262000d00600160a060020a0382163063ffffffff6200157d16565b915062000d1e600160a060020a038216848463ffffffff620016ae16565b60408051808201909152601d81527f5245434f5645525f544f4b454e5f5452414e534645525f4641494c4544000000602082015290151562000dbe576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825283818151815260200191508051906020019080838360008381101562000b9b57818101518382015260200162000b81565b505b83600160a060020a031683600160a060020a03167f596caf56044b55fb8c4ca640089bbc2b63cae3e978b851f5745cbb7c5b288e02846040518082815260200191505060405180910390a350505050565b6000805160206200262583398151915262000e2d8484620012f2565b62000e3a85858562001424565b5050505050565b600091825260208281526040808420928452919052902054600160a060020a031690565b60006000805160206200262583398151915262000e926000805160206200264583398151915287620012f2565b62000eae60008051602062002645833981519152888862001300565b620007b13088875b60008084848462000ec662001818565b600160a060020a038416815260208082018490526060604083018181528451918401919091528351909160808401919085019080838360005b8381101562000f1957818101518382015260200162000eff565b50505050905090810190601f16801562000f475780820380516001836020036101000a031916815260200191505b50945050505050604051809103906000f08015801562000f6b573d6000803e3d6000fd5b5060408051600160a060020a03831681526000602082015280820187905290519192507fd880e726dced8808d727f02dd0e6fdd3a945b24bfee77e13367bcbe61ddbaf47919081900360600190a1949350505050565b6000805160206200264583398151915290565b600062000a437fd6f028ca0e8edb4a8c9757ca4fdccab25fa1e0317da1188108f7d2dee14902fb7fe3262375f45a6e2026b7e7b18c2b807434f2508fe1a2a3dfb493c7df8f4aad6a62000e41565b60006000196200103162000a16565b14905090565b6040805160008082526020820190925262001056908490849062001081565b9392505050565b7fe3262375f45a6e2026b7e7b18c2b807434f2508fe1a2a3dfb493c7df8f4aad6a90565b6000808484846200109162001829565b600160a060020a038416815260208082018490526060604083018181528451918401919091528351909160808401919085019080838360005b83811015620010e4578181015183820152602001620010ca565b50505050905090810190601f168015620011125780820380516001836020036101000a031916815260200191505b50945050505050604051809103906000f08015801562001136573d6000803e3d6000fd5b5060408051600160a060020a03831681526001602082015280820187905290519192507fd880e726dced8808d727f02dd0e6fdd3a945b24bfee77e13367bcbe61ddbaf47919081900360600190a1949350505050565b6000806200119962000fd4565b9050600160a060020a03811615801590620012c557506040517ffdef9106000000000000000000000000000000000000000000000000000000008152600160a060020a03878116600483019081528782166024840152604483018790526080606484019081528651608485015286519285169363fdef9106938b938b938b938b9360a490910190602085019080838360005b83811015620012455781810151838201526020016200122b565b50505050905090810190601f168015620012735780820380516001836020036101000a031916815260200191505b5095505050505050602060405180830381600087803b1580156200129657600080fd5b505af1158015620012ab573d6000803e3d6000fd5b505050506040513d6020811015620012c257600080fd5b50515b9695505050505050565b6040805160008082526020820190925262001056908490849062000eb6565b4390565b606062001056838362001732565b60006200130e848462000e41565b9050600160a060020a03811615620013d35760408051808201909152601981527f4b45524e454c5f494e56414c49445f4150505f4348414e4745000000000000006020820152600160a060020a0382811690841614620013cc576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825283818151815260200191508051906020019080838360008381101562000b9b57818101518382015260200162000b81565b50620013e0565b620013e084848462001424565b50505050565b62001422620013f4620012ee565b7febb05b386a8d34882b8711d156f463690983dc47815980fb82aeeff1aa43579e9063ffffffff6200178f16565b565b6200142f816200154e565b60408051808201909152601781527f4b45524e454c5f4150505f4e4f545f434f4e54524143540000000000000000006020820152901515620014cf576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825283818151815260200191508051906020019080838360008381101562000b9b57818101518382015260200162000b81565b50600083815260208181526040808320858452825291829020805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03851690811790915582519081529151849286927f2ec1ae0a449b7ae354b9dacfb3ade6b6332ba26b7fcbb935835fa39dd7263b2392918290030190a3505050565b5490565b600080600160a060020a03831615156200156c576000915062001577565b823b90506000811191505b50919050565b60408051600160a060020a0383166024808301919091528251808303909101815260449091019091526020810180517bffffffffffffffffffffffffffffffffffffffffffffffffffffffff167f70a08231000000000000000000000000000000000000000000000000000000001790526000908180620015ff868462001793565b60408051808201909152601c81527f534146455f4552435f32305f42414c414e43455f52455645525445440000000060208201529193509150821515620016a4576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825283818151815260200191508051906020019080838360008381101562000b9b57818101518382015260200162000b81565b5095945050505050565b60408051600160a060020a038416602482015260448082018490528251808303909101815260649091019091526020810180517bffffffffffffffffffffffffffffffffffffffffffffffffffffffff167fa9059cbb0000000000000000000000000000000000000000000000000000000017905260009062000a078582620017c5565b6040805160028082526060808301845292602083019080388339019050509050828160008151811015156200176357fe5b6020908102909101015280518290829060019081106200177f57fe5b6020908102909101015292915050565b9055565b6000806000806040516020818751602089018a5afa92506000831115620017b957805191505b50909590945092505050565b6000806040516020818551602087016000895af160008111156200180e573d8015620017fa576020811462001804576200180c565b600193506200180c565b600183511493505b505b5090949350505050565b6040516106fd806200183b83390190565b6040516106ed8062001f38833901905600608060405234801561001057600080fd5b506040516106fd3803806106fd8339810160409081528151602083015191830151909201828282600061004b8464010000000061017a810204565b61005d836401000000006101a2810204565b61006f836401000000006101d9810204565b90506000825111156101185761008d816401000000006102a9810204565b151561009857600080fd5b80600160a060020a03168260405180828051906020019080838360005b838110156100cd5781810151838201526020016100b5565b50505050905090810190601f1680156100fa5780820380516001836020036101000a031916815260200191505b50915050600060405180830381855af4915050151561011857600080fd5b50505050610145610137836101d9640100000000026401000000009004565b6401000000006102d6810204565b6101676101596401000000006102fb810204565b6401000000006102a9810204565b151561017257600080fd5b505050610354565b61019f6000805160206106bd8339815191528264010000000061032661032682021704565b50565b61019f7fd625496217aa6a3453eecb9c3489dc5a53e6c67b444329ea2b2cbc9ff547639b8264010000000061032661032682021704565b60006101ec64010000000061032a810204565b604080517fbe00bbd80000000000000000000000000000000000000000000000000000000081527ff1f3eb40f5bc1ad1344716ced8b8a0431d840b5783aea1fd01786bc26f35ac0f6004820152602481018590529051600160a060020a03929092169163be00bbd8916044808201926020929091908290030181600087803b15801561027757600080fd5b505af115801561028b573d6000803e3d6000fd5b505050506040513d60208110156102a157600080fd5b505192915050565b600080600160a060020a03831615156102c557600091506102d0565b823b90506000811191505b50919050565b61019f6000805160206106dd8339815191528264010000000061032661032682021704565b60006103216000805160206106dd83398151915264010000000061031e61035082021704565b905090565b9055565b60006103216000805160206106bd83398151915264010000000061031e61035082021704565b5490565b61035a806103636000396000f30060806040526004361061006c5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416634555d5c9811461012b57806348a0c8dd146101525780635c60da1b1461017b57806380afdea8146101b9578063d4aae0c4146101ce575b6127107f665fd576fbbe6f247aff98f5c94a561e3f71ec2d3c988d56f12d342396c50cea6000825a10156100e15760003411361583541616156100dc576040513381523460208201527f15eeaa57c7bd188c1388020bcadc2c436ec60d647d36ef5b9eb3c742217ddee1604082a1005b600080fd5b6100e96101e3565b9050610126816000368080601f016020809104026020016040519081016040528093929190818152602001838380828437506101f2945050505050565b505050005b34801561013757600080fd5b50610140610233565b60408051918252519081900360200190f35b34801561015e57600080fd5b50610167610238565b604080519115158252519081900360200190f35b34801561018757600080fd5b506101906101e3565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b3480156101c557600080fd5b50610140610263565b3480156101da57600080fd5b5061019061028e565b60006101ed6102b9565b905090565b60006101fd836102e4565b151561020857600080fd5b612710905060008083516020850186855a03f43d604051816000823e82801561022f578282f35b8282fd5b600190565b60006101ed7f665fd576fbbe6f247aff98f5c94a561e3f71ec2d3c988d56f12d342396c50cea61031e565b60006101ed7fd625496217aa6a3453eecb9c3489dc5a53e6c67b444329ea2b2cbc9ff547639b61031e565b60006101ed7f4172f0f7d2289153072b0a6ca36959e0cbe2efc3afe50fc81636caa96338137b61031e565b60006101ed7fdee64df20d65e53d7f51cb6ab6d921a0a6a638a91e942e1d8d02df28e31c038e61031e565b60008073ffffffffffffffffffffffffffffffffffffffff8316151561030d5760009150610318565b823b90506000811191505b50919050565b5490565b5490565b9055565b90555600a165627a7a72305820510a3ba3a08876979faab1b77d9db8021f536a5da5b8ca892a26bcff3b2791f400294172f0f7d2289153072b0a6ca36959e0cbe2efc3afe50fc81636caa96338137bdee64df20d65e53d7f51cb6ab6d921a0a6a638a91e942e1d8d02df28e31c038e608060405234801561001057600080fd5b506040516106ed3803806106ed8339810160409081528151602083015191830151909201828282600061004b84640100000000610124810204565b61005d8364010000000061014c810204565b61006f83640100000000610183810204565b90506000825111156101185761008d81640100000000610253810204565b151561009857600080fd5b80600160a060020a03168260405180828051906020019080838360005b838110156100cd5781810151838201526020016100b5565b50505050905090810190601f1680156100fa5780820380516001836020036101000a031916815260200191505b50915050600060405180830381855af4915050151561011857600080fd5b505050505050506102b3565b6101496000805160206106cd833981519152826401000000006103d761028082021704565b50565b6101497fd625496217aa6a3453eecb9c3489dc5a53e6c67b444329ea2b2cbc9ff547639b826401000000006103d761028082021704565b6000610196640100000000610284810204565b604080517fbe00bbd80000000000000000000000000000000000000000000000000000000081527ff1f3eb40f5bc1ad1344716ced8b8a0431d840b5783aea1fd01786bc26f35ac0f6004820152602481018590529051600160a060020a03929092169163be00bbd8916044808201926020929091908290030181600087803b15801561022157600080fd5b505af1158015610235573d6000803e3d6000fd5b505050506040513d602081101561024b57600080fd5b505192915050565b600080600160a060020a038316151561026f576000915061027a565b823b90506000811191505b50919050565b9055565b60006102aa6000805160206106cd8339815191526401000000006103cf6102af82021704565b905090565b5490565b61040b806102c26000396000f30060806040526004361061006c5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416634555d5c9811461012b57806348a0c8dd146101525780635c60da1b1461017b57806380afdea8146101b9578063d4aae0c4146101ce575b6127107f665fd576fbbe6f247aff98f5c94a561e3f71ec2d3c988d56f12d342396c50cea6000825a10156100e15760003411361583541616156100dc576040513381523460208201527f15eeaa57c7bd188c1388020bcadc2c436ec60d647d36ef5b9eb3c742217ddee1604082a1005b600080fd5b6100e96101e3565b9050610126816000368080601f016020809104026020016040519081016040528093929190818152602001838380828437506101fa945050505050565b505050005b34801561013757600080fd5b5061014061023b565b60408051918252519081900360200190f35b34801561015e57600080fd5b50610167610240565b604080519115158252519081900360200190f35b34801561018757600080fd5b506101906101e3565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b3480156101c557600080fd5b5061014061026b565b3480156101da57600080fd5b50610190610296565b60006101f56101f061026b565b6102c1565b905090565b600061020583610395565b151561021057600080fd5b612710905060008083516020850186855a03f43d604051816000823e828015610237578282f35b8282fd5b600290565b60006101f57f665fd576fbbe6f247aff98f5c94a561e3f71ec2d3c988d56f12d342396c50cea6103cf565b60006101f57fd625496217aa6a3453eecb9c3489dc5a53e6c67b444329ea2b2cbc9ff547639b6103cf565b60006101f57f4172f0f7d2289153072b0a6ca36959e0cbe2efc3afe50fc81636caa96338137b6103cf565b60006102cb610296565b604080517fbe00bbd80000000000000000000000000000000000000000000000000000000081527ff1f3eb40f5bc1ad1344716ced8b8a0431d840b5783aea1fd01786bc26f35ac0f600482015260248101859052905173ffffffffffffffffffffffffffffffffffffffff929092169163be00bbd8916044808201926020929091908290030181600087803b15801561036357600080fd5b505af1158015610377573d6000803e3d6000fd5b505050506040513d602081101561038d57600080fd5b505192915050565b60008073ffffffffffffffffffffffffffffffffffffffff831615156103be57600091506103c9565b823b90506000811191505b50919050565b5490565b5490565b9055565b90555600a165627a7a723058209bb54ff52b0fcf9b9f2d4e4c397a6bf92cf2ab9e7716cb44c68fdf01c16e338400294172f0f7d2289153072b0a6ca36959e0cbe2efc3afe50fc81636caa96338137bb6d92708f3d4817afc106147d969e229ced5c46e65e0a5002a0d391287762bd0f1f3eb40f5bc1ad1344716ced8b8a0431d840b5783aea1fd01786bc26f35ac0fa165627a7a723058207cb92783b2648333ce7bc0a1db2f89e689ee9d9447336dcbc6de69bddff542550029";

    public static final String FUNC_HASINITIALIZED = "hasInitialized";

    public static final String FUNC_KERNEL_APP_ID = "KERNEL_APP_ID";

    public static final String FUNC_APP_ADDR_NAMESPACE = "APP_ADDR_NAMESPACE";

    public static final String FUNC_GETRECOVERYVAULT = "getRecoveryVault";

    public static final String FUNC_newAppInstance = "newAppInstance";

    public static final String FUNC_APPS = "apps";

    public static final String FUNC_INITIALIZE = "initialize";

    public static final String FUNC_CORE_NAMESPACE = "CORE_NAMESPACE";

    public static final String FUNC_ALLOWRECOVERABILITY = "allowRecoverability";

    public static final String FUNC_RECOVERYVAULTAPPID = "recoveryVaultAppId";

    public static final String FUNC_GETINITIALIZATIONBLOCK = "getInitializationBlock";

    public static final String FUNC_SETRECOVERYVAULTAPPID = "setRecoveryVaultAppId";

    public static final String FUNC_APP_MANAGER_ROLE = "APP_MANAGER_ROLE";

    public static final String FUNC_newPinnedAppInstance = "newPinnedAppInstance";

    public static final String FUNC_TRANSFERTOVAULT = "transferToVault";

    public static final String FUNC_SETAPP = "setApp";

    public static final String FUNC_GETAPP = "getApp";

    public static final String FUNC_newAppProxyPinned = "newAppProxyPinned";

    public static final String FUNC_APP_BASES_NAMESPACE = "APP_BASES_NAMESPACE";

    public static final String FUNC_ACL = "acl";

    public static final String FUNC_ISPETRIFIED = "isPetrified";

    public static final String FUNC_newAppProxy = "newAppProxy";

    public static final String FUNC_DEFAULT_ACL_APP_ID = "DEFAULT_ACL_APP_ID";

    public static final String FUNC_HASPERMISSION = "hasPermission";

    public static final Event NEWAPPPROXY_EVENT = new Event("NewAppProxy", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Bytes32>() {}));
    ;

    public static final Event RECOVERTOVAULT_EVENT = new Event("RecoverToVault", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event SETAPP_EVENT = new Event("SetApp", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Bytes32>(true) {}, new TypeReference<Address>() {}));
    ;

    @Deprecated
    protected Kernel(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Kernel(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Kernel(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Kernel(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Bool> hasInitialized() {
        final Function function = new Function(FUNC_HASINITIALIZED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Bytes32> KERNEL_APP_ID() {
        final Function function = new Function(FUNC_KERNEL_APP_ID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Bytes32> APP_ADDR_NAMESPACE() {
        final Function function = new Function(FUNC_APP_ADDR_NAMESPACE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Address> getRecoveryVault() {
        final Function function = new Function(FUNC_GETRECOVERYVAULT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> newAppInstance(Bytes32 _appId, Address _appBase, DynamicBytes _initializePayload, Bool _setDefault) {
        final Function function = new Function(
                FUNC_newAppInstance, 
                Arrays.<Type>asList(_appId, _appBase, _initializePayload, _setDefault), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Address> apps(Bytes32 param0, Bytes32 param1) {
        final Function function = new Function(FUNC_APPS, 
                Arrays.<Type>asList(param0, param1), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> initialize(Address _baseAcl, Address _permissionsCreator) {
        final Function function = new Function(
                FUNC_INITIALIZE, 
                Arrays.<Type>asList(_baseAcl, _permissionsCreator), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Bytes32> CORE_NAMESPACE() {
        final Function function = new Function(FUNC_CORE_NAMESPACE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Bool> allowRecoverability(Address token) {
        final Function function = new Function(FUNC_ALLOWRECOVERABILITY, 
                Arrays.<Type>asList(token), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> newAppInstance(Bytes32 _appId, Address _appBase) {
        final Function function = new Function(
                FUNC_newAppInstance, 
                Arrays.<Type>asList(_appId, _appBase), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Bytes32> recoveryVaultAppId() {
        final Function function = new Function(FUNC_RECOVERYVAULTAPPID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Uint256> getInitializationBlock() {
        final Function function = new Function(FUNC_GETINITIALIZATIONBLOCK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setRecoveryVaultAppId(Bytes32 _recoveryVaultAppId) {
        final Function function = new Function(
                FUNC_SETRECOVERYVAULTAPPID, 
                Arrays.<Type>asList(_recoveryVaultAppId), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Bytes32> APP_MANAGER_ROLE() {
        final Function function = new Function(FUNC_APP_MANAGER_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> newPinnedAppInstance(Bytes32 _appId, Address _appBase) {
        final Function function = new Function(
                FUNC_newPinnedAppInstance, 
                Arrays.<Type>asList(_appId, _appBase), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferToVault(Address _token) {
        final Function function = new Function(
                FUNC_TRANSFERTOVAULT, 
                Arrays.<Type>asList(_token), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setApp(Bytes32 _namespace, Bytes32 _appId, Address _app) {
        final Function function = new Function(
                FUNC_SETAPP, 
                Arrays.<Type>asList(_namespace, _appId, _app), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Address> getApp(Bytes32 _namespace, Bytes32 _appId) {
        final Function function = new Function(FUNC_GETAPP, 
                Arrays.<Type>asList(_namespace, _appId), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> newPinnedAppInstance(Bytes32 _appId, Address _appBase, DynamicBytes _initializePayload, Bool _setDefault) {
        final Function function = new Function(
                FUNC_newPinnedAppInstance, 
                Arrays.<Type>asList(_appId, _appBase, _initializePayload, _setDefault), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> newAppProxyPinned(Address _kernel, Bytes32 _appId, DynamicBytes _initializePayload) {
        final Function function = new Function(
                FUNC_newAppProxyPinned, 
                Arrays.<Type>asList(_kernel, _appId, _initializePayload), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Bytes32> APP_BASES_NAMESPACE() {
        final Function function = new Function(FUNC_APP_BASES_NAMESPACE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Address> acl() {
        final Function function = new Function(FUNC_ACL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<Bool> isPetrified() {
        final Function function = new Function(FUNC_ISPETRIFIED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> newAppProxy(Address _kernel, Bytes32 _appId) {
        final Function function = new Function(
                FUNC_newAppProxy, 
                Arrays.<Type>asList(_kernel, _appId), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Bytes32> DEFAULT_ACL_APP_ID() {
        final Function function = new Function(FUNC_DEFAULT_ACL_APP_ID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> newAppProxy(Address _kernel, Bytes32 _appId, DynamicBytes _initializePayload) {
        final Function function = new Function(
                FUNC_newAppProxy, 
                Arrays.<Type>asList(_kernel, _appId, _initializePayload), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Bool> hasPermission(Address _who, Address _where, Bytes32 _what, DynamicBytes _how) {
        final Function function = new Function(FUNC_HASPERMISSION, 
                Arrays.<Type>asList(_who, _where, _what, _how), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> newAppProxyPinned(Address _kernel, Bytes32 _appId) {
        final Function function = new Function(
                FUNC_newAppProxyPinned, 
                Arrays.<Type>asList(_kernel, _appId), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<NewAppProxyEventResponse> getNewAppProxyEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(NEWAPPPROXY_EVENT, transactionReceipt);
        ArrayList<NewAppProxyEventResponse> responses = new ArrayList<NewAppProxyEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            NewAppProxyEventResponse typedResponse = new NewAppProxyEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.proxy = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.isUpgradeable = (Bool) eventValues.getNonIndexedValues().get(1);
            typedResponse.appId = (Bytes32) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewAppProxyEventResponse> newAppProxyEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, NewAppProxyEventResponse>() {
            @Override
            public NewAppProxyEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(NEWAPPPROXY_EVENT, log);
                NewAppProxyEventResponse typedResponse = new NewAppProxyEventResponse();
                typedResponse.log = log;
                typedResponse.proxy = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.isUpgradeable = (Bool) eventValues.getNonIndexedValues().get(1);
                typedResponse.appId = (Bytes32) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public Flowable<NewAppProxyEventResponse> newAppProxyEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWAPPPROXY_EVENT));
        return newAppProxyEventFlowable(filter);
    }

    public List<RecoverToVaultEventResponse> getRecoverToVaultEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(RECOVERTOVAULT_EVENT, transactionReceipt);
        ArrayList<RecoverToVaultEventResponse> responses = new ArrayList<RecoverToVaultEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            RecoverToVaultEventResponse typedResponse = new RecoverToVaultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.vault = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.token = (Address) eventValues.getIndexedValues().get(1);
            typedResponse.amount = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RecoverToVaultEventResponse> recoverToVaultEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, RecoverToVaultEventResponse>() {
            @Override
            public RecoverToVaultEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(RECOVERTOVAULT_EVENT, log);
                RecoverToVaultEventResponse typedResponse = new RecoverToVaultEventResponse();
                typedResponse.log = log;
                typedResponse.vault = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.token = (Address) eventValues.getIndexedValues().get(1);
                typedResponse.amount = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<RecoverToVaultEventResponse> recoverToVaultEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RECOVERTOVAULT_EVENT));
        return recoverToVaultEventFlowable(filter);
    }

    public List<SetAppEventResponse> getSetAppEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(SETAPP_EVENT, transactionReceipt);
        ArrayList<SetAppEventResponse> responses = new ArrayList<SetAppEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            SetAppEventResponse typedResponse = new SetAppEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.namespace = (Bytes32) eventValues.getIndexedValues().get(0);
            typedResponse.appId = (Bytes32) eventValues.getIndexedValues().get(1);
            typedResponse.app = (Address) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SetAppEventResponse> setAppEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, SetAppEventResponse>() {
            @Override
            public SetAppEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(SETAPP_EVENT, log);
                SetAppEventResponse typedResponse = new SetAppEventResponse();
                typedResponse.log = log;
                typedResponse.namespace = (Bytes32) eventValues.getIndexedValues().get(0);
                typedResponse.appId = (Bytes32) eventValues.getIndexedValues().get(1);
                typedResponse.app = (Address) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<SetAppEventResponse> setAppEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SETAPP_EVENT));
        return setAppEventFlowable(filter);
    }

    @Deprecated
    public static Kernel load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Kernel(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Kernel load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Kernel(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Kernel load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Kernel(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Kernel load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Kernel(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Kernel> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, Bool _shouldPetrify) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_shouldPetrify));
        return deployRemoteCall(Kernel.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Kernel> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, Bool _shouldPetrify) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_shouldPetrify));
        return deployRemoteCall(Kernel.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Kernel> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Bool _shouldPetrify) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_shouldPetrify));
        return deployRemoteCall(Kernel.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Kernel> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Bool _shouldPetrify) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_shouldPetrify));
        return deployRemoteCall(Kernel.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class NewAppProxyEventResponse extends BaseEventResponse {
        public Address proxy;

        public Bool isUpgradeable;

        public Bytes32 appId;
    }

    public static class RecoverToVaultEventResponse extends BaseEventResponse {
        public Address vault;

        public Address token;

        public Uint256 amount;
    }

    public static class SetAppEventResponse extends BaseEventResponse {
        public Bytes32 namespace;

        public Bytes32 appId;

        public Address app;
    }
}
