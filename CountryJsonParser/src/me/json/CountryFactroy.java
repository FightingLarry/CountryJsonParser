package me.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.json.model.City;
import me.json.model.Province;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CountryFactroy {

	private static final String JSON_FILE = "json/country.json";

	public static void make() {
		try {
			File file = new File(JSON_FILE);
			if (file.exists() && file.isFile()) {
				ObjectMapper mapper = new ObjectMapper();
				JsonFactory jsonFactory = new JsonFactory();
				JsonGenerator jsonGenerator = jsonFactory.createGenerator(file,
						JsonEncoding.UTF8);
				mapper.writeValue(jsonGenerator, makeProvinces());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void analyse() {

		JsonFactory f = new JsonFactory();
		try {
			JsonParser jsonParser = f.createParser(new File(JSON_FILE));
			List<Province> list = null;
			if (jsonParser.getCurrentToken() != JsonToken.VALUE_NULL) {

				list = new ArrayList<Province>();
				while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
					Province province = Province.fromJsonParser(jsonParser);
					list.add(province);
					jsonParser.skipChildren();
				}

			}
			if (list != null && list.size() > 0) {
				for (Province province : list) {
					System.out.println(province.getName());
				}
			}

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// CountryFactroy.make();
		analyse();
	}

	private static List<Province> makeProvinces() {
		List<Province> provinces = new ArrayList<Province>();
		// '11'=>array('name'=>'北京','city'=>array('1'=>'东城','2'=>'西城','3'=>'崇文','4'=>'宣武','5'=>'朝阳','6'=>'丰台','7'=>'石景山','8'=>'海淀','9'=>'门头沟','11'=>'房山','12'=>'通州','13'=>'顺义','21'=>'昌平','24'=>'大兴','26'=>'平谷','27'=>'怀柔','28'=>'密云','29'=>'延庆',)),
		List<City> bj = new ArrayList<City>();
		bj.add(new City(1, "东城"));
		bj.add(new City(2, "西城"));
		bj.add(new City(3, "崇文"));
		bj.add(new City(4, "宣武"));
		bj.add(new City(5, "朝阳"));
		bj.add(new City(6, "丰台"));
		bj.add(new City(7, "石景山"));
		bj.add(new City(8, "海淀"));
		bj.add(new City(9, "门头沟"));
		bj.add(new City(11, "房山"));
		bj.add(new City(12, "通州"));
		bj.add(new City(13, "顺义"));
		bj.add(new City(21, "昌平"));
		bj.add(new City(24, "大兴"));
		bj.add(new City(26, "平谷"));
		bj.add(new City(27, "怀柔"));
		bj.add(new City(28, "密云"));
		bj.add(new City(29, "延庆"));
		provinces.add(new Province(11, "北京", bj));

		/*
		 * '12'=>array('name'=>'天津','city'=>array('1'=>'和平','2'=>'河东','3'=>'河西','4'=>'南开','5'=>'河北','6'=>'红桥','7'=>'塘沽','8'=>'汉沽','9'=>'大港','10'=>'东丽','11'=>'西青','12'=>'津南','13'=>'北辰','21'=>'宁河','22'=>'武清','23'=>'静海','24'=>'宝坻','25'=>'蓟县',)),
		 */
		List<City> tj = new ArrayList<City>();
		tj.add(new City(1, "和平"));
		tj.add(new City(2, "河东"));
		tj.add(new City(3, "河西"));
		tj.add(new City(4, "南开"));
		tj.add(new City(5, "河北"));
		tj.add(new City(6, "红桥"));
		tj.add(new City(7, "塘沽"));
		tj.add(new City(8, "汉沽"));
		tj.add(new City(9, "大港"));
		tj.add(new City(10, "东丽"));
		tj.add(new City(11, "西青"));
		tj.add(new City(12, "津南"));
		tj.add(new City(13, "北辰"));
		tj.add(new City(21, "宁河"));
		tj.add(new City(22, "武清"));
		tj.add(new City(23, "静海"));
		tj.add(new City(24, "宝坻"));
		tj.add(new City(25, "蓟县"));
		provinces.add(new Province(12, "天津", tj));

		/* '13'=>array('name'=>'河北','city'=>array('1'=>'石家庄','2'=>'唐山','3'=>'秦皇岛','4'=>'邯郸','5'=>'邢台','6'=>'保定','7'=>'张家口','8'=>'承德','9'=>'沧州','10'=>'廊坊','11'=>'衡水',)), */
		List<City> hb = new ArrayList<City>();
		hb.add(new City(1, "石家庄"));
		hb.add(new City(2, "唐山"));
		hb.add(new City(3, "秦皇岛"));
		hb.add(new City(4, "邯郸"));
		hb.add(new City(5, "邢台"));
		hb.add(new City(6, "保定"));
		hb.add(new City(7, "张家口"));
		hb.add(new City(8, "承德"));
		hb.add(new City(9, "沧州"));
		hb.add(new City(10, "廊坊"));
		hb.add(new City(11, "衡水"));
		provinces.add(new Province(13, "河北", hb));

		/*
		 * '14'=>array('name'=>'山西','city'=>array('1'=>'太原','2'=>'大同','3'=>'阳泉','4'=>'长治','5'=>'晋城','6'=>'朔州','7'=>'晋中','8'=>'运城','9'=>'忻州','10'=>'临汾','11'=>'吕梁',)),
		 */
		List<City> sx = new ArrayList<City>();
		sx.add(new City(1, "太原"));
		sx.add(new City(2, "大同"));
		sx.add(new City(3, "阳泉"));
		sx.add(new City(4, "长治"));
		sx.add(new City(5, "晋城"));
		sx.add(new City(6, "朔州"));
		sx.add(new City(7, "晋中"));
		sx.add(new City(8, "运城"));
		sx.add(new City(9, "忻州"));
		sx.add(new City(10, "临汾"));
		sx.add(new City(11, "吕梁"));
		provinces.add(new Province(14, "山西", sx));

		/* '15'=>array('name'=>'内蒙古','city'=>array('1'=>'呼和浩特','2'=>'包头','3'=>'乌海','4'=>'赤峰','5'=>'通辽','6'=>'鄂尔多斯','7'=>'呼伦贝尔','8'=>'巴彦淖尔','9'=>'乌兰察布','22'=>'兴安','25'=>'锡林郭勒','29'=>'阿拉善',)), */
		List<City> nmg = new ArrayList<City>();
		nmg.add(new City(1, "呼和浩特"));
		nmg.add(new City(2, "包头"));
		nmg.add(new City(3, "乌海"));
		nmg.add(new City(4, "赤峰"));
		nmg.add(new City(5, "通辽"));
		nmg.add(new City(6, "鄂尔多斯"));
		nmg.add(new City(7, "呼伦贝尔"));
		nmg.add(new City(8, "巴彦淖尔"));
		nmg.add(new City(9, "乌兰察布"));
		nmg.add(new City(22, "兴安"));
		nmg.add(new City(25, "锡林郭勒"));
		nmg.add(new City(29, "阿拉善"));
		provinces.add(new Province(15, "内蒙古", nmg));

		/* '21'=>array('name'=>'辽宁','city'=>array('1'=>'沈阳','2'=>'大连','3'=>'鞍山','4'=>'抚顺','5'=>'本溪','6'=>'丹东','7'=>'锦州','8'=>'营口','9'=>'阜新','10'=>'辽阳','11'=>'盘锦','12'=>'铁岭','13'=>'朝阳','14'=>'葫芦岛',)), */
		List<City> ln = new ArrayList<City>();
		ln.add(new City(1, "沈阳"));
		ln.add(new City(2, "大连"));
		ln.add(new City(3, "鞍山"));
		ln.add(new City(4, "抚顺"));
		ln.add(new City(5, "本溪"));
		ln.add(new City(6, "丹东"));
		ln.add(new City(7, "锦州"));
		ln.add(new City(8, "营口"));
		ln.add(new City(9, "阜新"));
		ln.add(new City(10, "辽阳"));
		ln.add(new City(11, "盘锦"));
		ln.add(new City(12, "铁岭"));
		ln.add(new City(13, "朝阳"));
		ln.add(new City(14, "葫芦岛"));
		provinces.add(new Province(21, "辽宁", ln));

		/* '22'=>array('name'=>'吉林','city'=>array('1'=>'长春','2'=>'吉林','3'=>'四平','4'=>'辽源','5'=>'通化','6'=>'白山','7'=>'松原','8'=>'白城','24'=>'延边',)), */
		List<City> jl = new ArrayList<City>();
		jl.add(new City(1, "长春"));
		jl.add(new City(2, "吉林"));
		jl.add(new City(3, "四平"));
		jl.add(new City(4, "辽源"));
		jl.add(new City(5, "通化"));
		jl.add(new City(6, "白山"));
		jl.add(new City(7, "松原"));
		jl.add(new City(8, "白城"));
		jl.add(new City(24, "延边"));
		provinces.add(new Province(22, "吉林", jl));

		/* '23'=>array('name'=>'黑龙江','city'=>array('1'=>'哈尔滨','2'=>'齐齐哈尔','3'=>'鸡西','4'=>'鹤岗','5'=>'双鸭山','6'=>'大庆','7'=>'伊春','8'=>'佳木斯','9'=>'七台河','10'=>'牡丹江','11'=>'黑河','12'=>'绥化','27'=>'大兴安岭',)), */
		List<City> hlj = new ArrayList<City>();
		hlj.add(new City(1, "哈尔滨"));
		hlj.add(new City(2, "齐齐哈尔"));
		hlj.add(new City(3, "鸡西"));
		hlj.add(new City(4, "鹤岗"));
		hlj.add(new City(5, "双鸭山"));
		hlj.add(new City(6, "大庆"));
		hlj.add(new City(7, "伊春"));
		hlj.add(new City(8, "佳木斯"));
		hlj.add(new City(9, "七台河"));
		hlj.add(new City(10, "牡丹江"));
		hlj.add(new City(11, "黑河"));
		hlj.add(new City(12, "绥化"));
		hlj.add(new City(27, "大兴安岭"));
		provinces.add(new Province(23, "黑龙江", hlj));

		/* '31'=>array('name'=>'上海','city'=>array('1'=>'黄浦','3'=>'卢湾','4'=>'徐汇','5'=>'长宁','6'=>'静安','7'=>'普陀','8'=>'闸北','9'=>'虹口','11'=>'杨浦','12'=>'闵行','13'=>'宝山','14'=>'嘉定','15'=>'浦东新','16'=>'金山','17'=>'松江','25'=>'南汇','26'=>'奉贤','29'=>'青浦','30'=>'崇明',)), */
		List<City> sh = new ArrayList<City>();
		sh.add(new City(1, "黄浦"));
		sh.add(new City(3, "卢湾"));
		sh.add(new City(4, "徐汇"));
		sh.add(new City(5, "长宁"));
		sh.add(new City(6, "静安"));
		sh.add(new City(7, "普陀"));
		sh.add(new City(8, "闸北"));
		sh.add(new City(9, "虹口"));
		sh.add(new City(11, "杨浦"));
		sh.add(new City(12, "闵行"));
		sh.add(new City(13, "宝山"));
		sh.add(new City(14, "嘉定"));
		sh.add(new City(15, "浦东新"));
		sh.add(new City(16, "金山"));
		sh.add(new City(17, "松江"));
		sh.add(new City(25, "南汇"));
		sh.add(new City(26, "奉贤"));
		sh.add(new City(29, "青浦"));
		sh.add(new City(30, "崇明"));
		provinces.add(new Province(31, "上海", sh));

		/* '32'=>array('name'=>'江苏','city'=>array('1'=>'南京','2'=>'无锡','3'=>'徐州','4'=>'常州','5'=>'苏州','6'=>'南通','7'=>'连云港','8'=>'淮安','9'=>'盐城','10'=>'扬州','11'=>'镇江','12'=>'泰州','13'=>'宿迁',)), */
		List<City> js = new ArrayList<City>();
		js.add(new City(1, "南京"));
		js.add(new City(2, "无锡"));
		js.add(new City(3, "徐州"));
		js.add(new City(4, "常州"));
		js.add(new City(5, "苏州"));
		js.add(new City(6, "南通"));
		js.add(new City(7, "连云港"));
		js.add(new City(8, "淮安"));
		js.add(new City(9, "盐城"));
		js.add(new City(10, "扬州'"));
		js.add(new City(11, "镇江"));
		js.add(new City(12, "泰州"));
		js.add(new City(13, "宿迁"));
		provinces.add(new Province(32, "江苏", js));

		/* '33'=>array('name'=>'浙江','city'=>array('1'=>'杭州','2'=>'宁波','3'=>'温州','4'=>'嘉兴','5'=>'湖州','6'=>'绍兴','7'=>'金华','8'=>'衢州','9'=>'舟山','10'=>'台州','11'=>'丽水',)), */
		List<City> zj = new ArrayList<City>();
		zj.add(new City(1, "杭州"));
		zj.add(new City(2, "宁波"));
		zj.add(new City(3, "温州"));
		zj.add(new City(4, "嘉兴"));
		zj.add(new City(5, "湖州"));
		zj.add(new City(6, "绍兴"));
		zj.add(new City(7, "金华"));
		zj.add(new City(8, "衢州"));
		zj.add(new City(9, "舟山"));
		zj.add(new City(10, "台州"));
		zj.add(new City(11, "丽水"));
		provinces.add(new Province(33, "浙江", zj));

		/* '34'=>array('name'=>'安徽','city'=>array('1'=>'合肥','2'=>'芜湖','3'=>'蚌埠','4'=>'淮南','5'=>'马鞍山','6'=>'淮北','7'=>'铜陵','8'=>'安庆','10'=>'黄山','11'=>'滁州','12'=>'阜阳','13'=>'宿州','14'=>'巢湖','15'=>'六安','16'=>'亳州','17'=>'池州','18'=>'宣城',)), */
		List<City> ah = new ArrayList<City>();
		ah.add(new City(1, "合肥"));
		ah.add(new City(2, "芜湖"));
		ah.add(new City(3, "蚌埠"));
		ah.add(new City(4, "淮南"));
		ah.add(new City(5, "马鞍山"));
		ah.add(new City(6, "淮北"));
		ah.add(new City(7, "铜陵"));
		ah.add(new City(8, "安庆"));
		ah.add(new City(10, "黄山"));
		ah.add(new City(11, "滁州"));
		ah.add(new City(12, "阜阳"));
		ah.add(new City(13, "宿州"));
		ah.add(new City(14, "巢湖"));
		ah.add(new City(15, "六安"));
		ah.add(new City(16, "亳州"));
		ah.add(new City(17, "池州"));
		ah.add(new City(18, "宣城"));
		provinces.add(new Province(34, "安徽", ah));

		/* '35'=>array('name'=>'福建','city'=>array('1'=>'福州','2'=>'厦门','3'=>'莆田','4'=>'三明','5'=>'泉州','6'=>'漳州','7'=>'南平','8'=>'龙岩','9'=>'宁德',)), */
		List<City> fj = new ArrayList<City>();
		fj.add(new City(1, "福州"));
		fj.add(new City(2, "厦门"));
		fj.add(new City(3, "莆田"));
		fj.add(new City(4, "三明"));
		fj.add(new City(5, "泉州"));
		fj.add(new City(6, "漳州"));
		fj.add(new City(7, "南平"));
		fj.add(new City(8, "龙岩"));
		fj.add(new City(9, "宁德"));
		provinces.add(new Province(35, "福建", fj));

		/* '36'=>array('name'=>'江西','city'=>array('1'=>'南昌','2'=>'景德镇','3'=>'萍乡','4'=>'九江','5'=>'新余','6'=>'鹰潭','7'=>'赣州','8'=>'吉安','9'=>'宜春','10'=>'抚州','11'=>'上饶',)), */
		List<City> jx = new ArrayList<City>();
		jx.add(new City(1, "南昌"));
		jx.add(new City(2, "景德镇"));
		jx.add(new City(3, "萍乡"));
		jx.add(new City(4, "九江"));
		jx.add(new City(5, "新余"));
		jx.add(new City(6, "鹰潭"));
		jx.add(new City(7, "赣州"));
		jx.add(new City(8, "吉安"));
		jx.add(new City(9, "宜春"));
		jx.add(new City(10, "抚州"));
		jx.add(new City(11, "上饶"));
		provinces.add(new Province(36, "江西", jx));

		/* '37'=>array('name'=>'山东','city'=>array('1'=>'济南','2'=>'青岛','3'=>'淄博','4'=>'枣庄','5'=>'东营','6'=>'烟台','7'=>'潍坊','8'=>'济宁','9'=>'泰安','10'=>'威海','11'=>'日照','12'=>'莱芜','13'=>'临沂','14'=>'德州','15'=>'聊城','16'=>'滨州','17'=>'菏泽',)), */
		List<City> sd = new ArrayList<City>();
		sd.add(new City(1, "济南"));
		sd.add(new City(2, "青岛"));
		sd.add(new City(3, "淄博"));
		sd.add(new City(4, "枣庄"));
		sd.add(new City(5, "东营"));
		sd.add(new City(6, "烟台"));
		sd.add(new City(7, "潍坊"));
		sd.add(new City(8, "济宁"));
		sd.add(new City(9, "泰安"));
		sd.add(new City(10, "威海"));
		sd.add(new City(11, "日照"));
		sd.add(new City(12, "莱芜"));
		sd.add(new City(13, "临沂"));
		sd.add(new City(14, "德州"));
		sd.add(new City(15, "聊城"));
		sd.add(new City(16, "滨州"));
		sd.add(new City(16, "菏泽"));
		provinces.add(new Province(37, "山东", sd));

		// /*
		// '37'=>array('name'=>'山东','city'=>array('1'=>'济南','2'=>'青岛','3'=>'淄博','4'=>'枣庄','5'=>'东营','6'=>'烟台','7'=>'潍坊','8'=>'济宁','9'=>'泰安','10'=>'威海','11'=>'日照','12'=>'莱芜','13'=>'临沂','14'=>'德州','15'=>'聊城','16'=>'滨州','17'=>'菏泽',)),
		// */
		// List<City> sd = new ArrayList<City>();
		// sd.add(new City(1, "济南"));
		// sd.add(new City(2, "青岛"));
		// sd.add(new City(3, "淄博"));
		// sd.add(new City(4, "枣庄"));
		// sd.add(new City(5, "东营"));
		// sd.add(new City(6, "烟台"));
		// sd.add(new City(7, "潍坊"));
		// sd.add(new City(8, "济宁"));
		// sd.add(new City(9, "泰安"));
		// sd.add(new City(10, "威海"));
		// sd.add(new City(11, "日照"));
		// sd.add(new City(12, "莱芜"));
		// sd.add(new City(13, "临沂"));
		// sd.add(new City(14, "德州"));
		// sd.add(new City(15, "聊城"));
		// sd.add(new City(16, "滨州"));
		// sd.add(new City(16, "菏泽"));
		// provinces.add(new Province(37, "山东", sd));

		return provinces;
	}

}
