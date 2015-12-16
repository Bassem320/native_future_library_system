package eg.edu.eulc.librarysystem.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import eg.edu.eulc.librarysystem.R;

public class BrowseActivity extends AppCompatActivity {
    ScrollView mainParent, parent = null;

    ScrollView level00, level01, level02, level03, level04, level05, level06, level07, level08, level09,
    level000, level001, level002, level003, level004, level005, level006, level007, level008, level009,
    level010, level011, level012, level013, level014, level015, level016, level017, level018, level019,
    level020, level021, level022, level023, level024, level025, level026, level027, level028, level029,
    level030, level031, level032, level033, level034, level035, level036, level037, level038, level039,
    level040, level041, level042, level043, level044, level045, level046, level047, level048, level049,
    level050, level051, level052, level053, level054, level055, level056, level057, level058, level059,
    level060, level061, level062, level063, level064, level065, level066, level067, level068, level069,
    level070, level071, level072, level073, level074, level075, level076, level077, level078, level079,
    level080, level081, level082, level083, level084, level085, level086, level087, level088, level089,
    level090, level091, level092, level093, level094, level095, level096, level097, level098, level099;

    LinearLayout subject00, subject01, subject02, subject03, subject04, subject05, subject06, subject07, subject08, subject09,
    subject10, subject11, subject12, subject13, subject14, subject15, subject16, subject17, subject18, subject19,
    subject20, subject21, subject22, subject23, subject24, subject25, subject26, subject27, subject28, subject29,
    subject30, subject31, subject32, subject33, subject34, subject35, subject36, subject37, subject38, subject39,
    subject40, subject41, subject42, subject43, subject44, subject45, subject46, subject47, subject48, subject49,
    subject50, subject51, subject52, subject53, subject54, subject55, subject56, subject57, subject58, subject59,
    subject60, subject61, subject62, subject63, subject64, subject65, subject66, subject67, subject68, subject69,
    subject70, subject71, subject72, subject73, subject74, subject75, subject76, subject77, subject78, subject79,
    subject80, subject81, subject82, subject83, subject84, subject85, subject86, subject87, subject88, subject89,
    subject90, subject91, subject92, subject93, subject94, subject95, subject96, subject97, subject98, subject99,
    subject000, subject001, subject002, subject003, subject004, subject005, subject006, subject007, subject008, subject009,
    subject010, subject011, subject012, subject013, subject014, subject015, subject016, subject017, subject018, subject019,
    subject020, subject021, subject022, subject023, subject024, subject025, subject026, subject027, subject028, subject029,
    subject030, subject031, subject032, subject033, subject034, subject035, subject036, subject037, subject038, subject039,
    subject040, subject041, subject042, subject043, subject044, subject045, subject046, subject047, subject048, subject049,
    subject050, subject051, subject052, subject053, subject054, subject055, subject056, subject057, subject058, subject059,
    subject060, subject061, subject062, subject063, subject064, subject065, subject066, subject067, subject068, subject069,
    subject070, subject071, subject072, subject073, subject074, subject075, subject076, subject077, subject078, subject079,
    subject080, subject081, subject082, subject083, subject084, subject085, subject086, subject087, subject088, subject089,
    subject090, subject091, subject092, subject093, subject094, subject095, subject096, subject097, subject098, subject099,
    subject100, subject101, subject102, subject103, subject104, subject105, subject106, subject107, subject108, subject109,
    subject110, subject111, subject112, subject113, subject114, subject115, subject116, subject117, subject118, subject119,
    subject120, subject121, subject122, subject123, subject124, subject125, subject126, subject127, subject128, subject129,
    subject130, subject131, subject132, subject133, subject134, subject135, subject136, subject137, subject138, subject139,
    subject140, subject141, subject142, subject143, subject144, subject145, subject146, subject147, subject148, subject149,
    subject150, subject151, subject152, subject153, subject154, subject155, subject156, subject157, subject158, subject159,
    subject160, subject161, subject162, subject163, subject164, subject165, subject166, subject167, subject168, subject169,
    subject170, subject171, subject172, subject173, subject174, subject175, subject176, subject177, subject178, subject179,
    subject180, subject181, subject182, subject183, subject184, subject185, subject186, subject187, subject188, subject189,
    subject190, subject191, subject192, subject193, subject194, subject195, subject196, subject197, subject198, subject199,
    subject200, subject201, subject202, subject203, subject204, subject205, subject206, subject207, subject208, subject209,
    subject210, subject211, subject212, subject213, subject214, subject215, subject216, subject217, subject218, subject219,
    subject220, subject221, subject222, subject223, subject224, subject225, subject226, subject227, subject228, subject229,
    subject230, subject231, subject232, subject233, subject234, subject235, subject236, subject237, subject238, subject239,
    subject240, subject241, subject242, subject243, subject244, subject245, subject246, subject247, subject248, subject249,
    subject250, subject251, subject252, subject253, subject254, subject255, subject256, subject257, subject258, subject259,
    subject260, subject261, subject262, subject263, subject264, subject265, subject266, subject267, subject268, subject269,
    subject270, subject271, subject272, subject273, subject274, subject275, subject276, subject277, subject278, subject279,
    subject280, subject281, subject282, subject283, subject284, subject285, subject286, subject287, subject288, subject289,
    subject290, subject291, subject292, subject293, subject294, subject295, subject296, subject297, subject298, subject299,
    subject300, subject301, subject302, subject303, subject304, subject305, subject306, subject307, subject308, subject309,
    subject310, subject311, subject312, subject313, subject314, subject315, subject316, subject317, subject318, subject319,
    subject320, subject321, subject322, subject323, subject324, subject325, subject326, subject327, subject328, subject329,
    subject330, subject331, subject332, subject333, subject334, subject335, subject336, subject337, subject338, subject339,
    subject340, subject341, subject342, subject343, subject344, subject345, subject346, subject347, subject348, subject349,
    subject350, subject351, subject352, subject353, subject354, subject355, subject356, subject357, subject358, subject359,
    subject360, subject361, subject362, subject363, subject364, subject365, subject366, subject367, subject368, subject369,
    subject370, subject371, subject372, subject373, subject374, subject375, subject376, subject377, subject378, subject379,
    subject380, subject381, subject382, subject383, subject384, subject385, subject386, subject387, subject388, subject389,
    subject390, subject391, subject392, subject393, subject394, subject395, subject396, subject397, subject398, subject399,
    subject400, subject401, subject402, subject403, subject404, subject405, subject406, subject407, subject408, subject409,
    subject410, subject411, subject412, subject413, subject414, subject415, subject416, subject417, subject418, subject419,
    subject420, subject421, subject422, subject423, subject424, subject425, subject426, subject427, subject428, subject429,
    subject430, subject431, subject432, subject433, subject434, subject435, subject436, subject437, subject438, subject439,
    subject440, subject441, subject442, subject443, subject444, subject445, subject446, subject447, subject448, subject449,
    subject450, subject451, subject452, subject453, subject454, subject455, subject456, subject457, subject458, subject459,
    subject460, subject461, subject462, subject463, subject464, subject465, subject466, subject467, subject468, subject469,
    subject470, subject471, subject472, subject473, subject474, subject475, subject476, subject477, subject478, subject479,
    subject480, subject481, subject482, subject483, subject484, subject485, subject486, subject487, subject488, subject489,
    subject490, subject491, subject492, subject493, subject494, subject495, subject496, subject497, subject498, subject499,
    subject500, subject501, subject502, subject503, subject504, subject505, subject506, subject507, subject508, subject509,
    subject510, subject511, subject512, subject513, subject514, subject515, subject516, subject517, subject518, subject519,
    subject520, subject521, subject522, subject523, subject524, subject525, subject526, subject527, subject528, subject529,
    subject530, subject531, subject532, subject533, subject534, subject535, subject536, subject537, subject538, subject539,
    subject540, subject541, subject542, subject543, subject544, subject545, subject546, subject547, subject548, subject549,
    subject550, subject551, subject552, subject553, subject554, subject555, subject556, subject557, subject558, subject559,
    subject560, subject561, subject562, subject563, subject564, subject565, subject566, subject567, subject568, subject569,
    subject570, subject571, subject572, subject573, subject574, subject575, subject576, subject577, subject578, subject579,
    subject580, subject581, subject582, subject583, subject584, subject585, subject586, subject587, subject588, subject589,
    subject590, subject591, subject592, subject593, subject594, subject595, subject596, subject597, subject598, subject599,
    subject600, subject601, subject602, subject603, subject604, subject605, subject606, subject607, subject608, subject609,
    subject610, subject611, subject612, subject613, subject614, subject615, subject616, subject617, subject618, subject619,
    subject620, subject621, subject622, subject623, subject624, subject625, subject626, subject627, subject628, subject629,
    subject630, subject631, subject632, subject633, subject634, subject635, subject636, subject637, subject638, subject639,
    subject640, subject641, subject642, subject643, subject644, subject645, subject646, subject647, subject648, subject649,
    subject650, subject651, subject652, subject653, subject654, subject655, subject656, subject657, subject658, subject659,
    subject660, subject661, subject662, subject663, subject664, subject665, subject666, subject667, subject668, subject669,
    subject670, subject671, subject672, subject673, subject674, subject675, subject676, subject677, subject678, subject679,
    subject680, subject681, subject682, subject683, subject684, subject685, subject686, subject687, subject688, subject689,
    subject690, subject691, subject692, subject693, subject694, subject695, subject696, subject697, subject698, subject699,
    subject700, subject701, subject702, subject703, subject704, subject705, subject706, subject707, subject708, subject709,
    subject710, subject711, subject712, subject713, subject714, subject715, subject716, subject717, subject718, subject719,
    subject720, subject721, subject722, subject723, subject724, subject725, subject726, subject727, subject728, subject729,
    subject730, subject731, subject732, subject733, subject734, subject735, subject736, subject737, subject738, subject739,
    subject740, subject741, subject742, subject743, subject744, subject745, subject746, subject747, subject748, subject749,
    subject750, subject751, subject752, subject753, subject754, subject755, subject756, subject757, subject758, subject759,
    subject760, subject761, subject762, subject763, subject764, subject765, subject766, subject767, subject768, subject769,
    subject770, subject771, subject772, subject773, subject774, subject775, subject776, subject777, subject778, subject779,
    subject780, subject781, subject782, subject783, subject784, subject785, subject786, subject787, subject788, subject789,
    subject790, subject791, subject792, subject793, subject794, subject795, subject796, subject797, subject798, subject799,
    subject800, subject801, subject802, subject803, subject804, subject805, subject806, subject807, subject808, subject809,
    subject810, subject811, subject812, subject813, subject814, subject815, subject816, subject817, subject818, subject819,
    subject820, subject821, subject822, subject823, subject824, subject825, subject826, subject827, subject828, subject829,
    subject830, subject831, subject832, subject833, subject834, subject835, subject836, subject837, subject838, subject839,
    subject840, subject841, subject842, subject843, subject844, subject845, subject846, subject847, subject848, subject849,
    subject850, subject851, subject852, subject853, subject854, subject855, subject856, subject857, subject858, subject859,
    subject860, subject861, subject862, subject863, subject864, subject865, subject866, subject867, subject868, subject869,
    subject870, subject871, subject872, subject873, subject874, subject875, subject876, subject877, subject878, subject879,
    subject880, subject881, subject882, subject883, subject884, subject885, subject886, subject887, subject888, subject889,
    subject890, subject891, subject892, subject893, subject894, subject895, subject896, subject897, subject898, subject899,
    subject900, subject901, subject902, subject903, subject904, subject905, subject906, subject907, subject908, subject909,
    subject910, subject911, subject912, subject913, subject914, subject915, subject916, subject917, subject918, subject919,
    subject920, subject921, subject922, subject923, subject924, subject925, subject926, subject927, subject928, subject929,
    subject930, subject931, subject932, subject933, subject934, subject935, subject936, subject937, subject938, subject939,
    subject940, subject941, subject942, subject943, subject944, subject945, subject946, subject947, subject948, subject949,
    subject950, subject951, subject952, subject953, subject954, subject955, subject956, subject957, subject958, subject959,
    subject960, subject961, subject962, subject963, subject964, subject965, subject966, subject967, subject968, subject969,
    subject970, subject971, subject972, subject973, subject974, subject975, subject976, subject977, subject978, subject979,
    subject980, subject981, subject982, subject983, subject984, subject985, subject986, subject987, subject988, subject989,
    subject990, subject991, subject992, subject993, subject994, subject995, subject996, subject997, subject998, subject999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        level00 = (ScrollView) findViewById(R.id.level00);
        level01 = (ScrollView) findViewById(R.id.level01);
        level02 = (ScrollView) findViewById(R.id.level02);
        level03 = (ScrollView) findViewById(R.id.level03);
        level04 = (ScrollView) findViewById(R.id.level04);
        level05 = (ScrollView) findViewById(R.id.level05);
        level06 = (ScrollView) findViewById(R.id.level06);
        level07 = (ScrollView) findViewById(R.id.level07);
        level08 = (ScrollView) findViewById(R.id.level08);
        level09 = (ScrollView) findViewById(R.id.level09);

        level000 = (ScrollView) findViewById(R.id.level000);
        level001 = (ScrollView) findViewById(R.id.level001);
        level002 = (ScrollView) findViewById(R.id.level002);
        level003 = (ScrollView) findViewById(R.id.level003);
        level004 = (ScrollView) findViewById(R.id.level004);
        level005 = (ScrollView) findViewById(R.id.level005);
        level006 = (ScrollView) findViewById(R.id.level006);
        level007 = (ScrollView) findViewById(R.id.level007);
        level008 = (ScrollView) findViewById(R.id.level008);
        level009 = (ScrollView) findViewById(R.id.level009);

        level010 = (ScrollView) findViewById(R.id.level010);
        level011 = (ScrollView) findViewById(R.id.level011);
        level012 = (ScrollView) findViewById(R.id.level012);
        level013 = (ScrollView) findViewById(R.id.level013);
        level014 = (ScrollView) findViewById(R.id.level014);
        level015 = (ScrollView) findViewById(R.id.level015);
        level016 = (ScrollView) findViewById(R.id.level016);
        level017 = (ScrollView) findViewById(R.id.level017);
        level018 = (ScrollView) findViewById(R.id.level018);
        level019 = (ScrollView) findViewById(R.id.level019);

        level020 = (ScrollView) findViewById(R.id.level020);
        level021 = (ScrollView) findViewById(R.id.level021);
        level022 = (ScrollView) findViewById(R.id.level022);
        level023 = (ScrollView) findViewById(R.id.level023);
        level024 = (ScrollView) findViewById(R.id.level024);
        level025 = (ScrollView) findViewById(R.id.level025);
        level026 = (ScrollView) findViewById(R.id.level026);
        level027 = (ScrollView) findViewById(R.id.level027);
        level028 = (ScrollView) findViewById(R.id.level028);
        level029 = (ScrollView) findViewById(R.id.level029);

        level030 = (ScrollView) findViewById(R.id.level030);
        level031 = (ScrollView) findViewById(R.id.level031);
        level032 = (ScrollView) findViewById(R.id.level032);
        level033 = (ScrollView) findViewById(R.id.level033);
        level034 = (ScrollView) findViewById(R.id.level034);
        level035 = (ScrollView) findViewById(R.id.level035);
        level036 = (ScrollView) findViewById(R.id.level036);
        level037 = (ScrollView) findViewById(R.id.level037);
        level038 = (ScrollView) findViewById(R.id.level038);
        level039 = (ScrollView) findViewById(R.id.level039);

        level040 = (ScrollView) findViewById(R.id.level040);
        level041 = (ScrollView) findViewById(R.id.level041);
        level042 = (ScrollView) findViewById(R.id.level042);
        level043 = (ScrollView) findViewById(R.id.level043);
        level044 = (ScrollView) findViewById(R.id.level044);
        level045 = (ScrollView) findViewById(R.id.level045);
        level046 = (ScrollView) findViewById(R.id.level046);
        level047 = (ScrollView) findViewById(R.id.level047);
        level048 = (ScrollView) findViewById(R.id.level048);
        level049 = (ScrollView) findViewById(R.id.level049);

        level050 = (ScrollView) findViewById(R.id.level050);
        level051 = (ScrollView) findViewById(R.id.level051);
        level052 = (ScrollView) findViewById(R.id.level052);
        level053 = (ScrollView) findViewById(R.id.level053);
        level054 = (ScrollView) findViewById(R.id.level054);
        level055 = (ScrollView) findViewById(R.id.level055);
        level056 = (ScrollView) findViewById(R.id.level056);
        level057 = (ScrollView) findViewById(R.id.level057);
        level058 = (ScrollView) findViewById(R.id.level058);
        level059 = (ScrollView) findViewById(R.id.level059);

        level060 = (ScrollView) findViewById(R.id.level060);
        level061 = (ScrollView) findViewById(R.id.level061);
        level062 = (ScrollView) findViewById(R.id.level062);
        level063 = (ScrollView) findViewById(R.id.level063);
        level064 = (ScrollView) findViewById(R.id.level064);
        level065 = (ScrollView) findViewById(R.id.level065);
        level066 = (ScrollView) findViewById(R.id.level066);
        level067 = (ScrollView) findViewById(R.id.level067);
        level068 = (ScrollView) findViewById(R.id.level068);
        level069 = (ScrollView) findViewById(R.id.level069);

        level070 = (ScrollView) findViewById(R.id.level070);
        level071 = (ScrollView) findViewById(R.id.level071);
        level072 = (ScrollView) findViewById(R.id.level072);
        level073 = (ScrollView) findViewById(R.id.level073);
        level074 = (ScrollView) findViewById(R.id.level074);
        level075 = (ScrollView) findViewById(R.id.level075);
        level076 = (ScrollView) findViewById(R.id.level076);
        level077 = (ScrollView) findViewById(R.id.level077);
        level078 = (ScrollView) findViewById(R.id.level078);
        level079 = (ScrollView) findViewById(R.id.level079);

        level080 = (ScrollView) findViewById(R.id.level080);
        level081 = (ScrollView) findViewById(R.id.level081);
        level082 = (ScrollView) findViewById(R.id.level082);
        level083 = (ScrollView) findViewById(R.id.level083);
        level084 = (ScrollView) findViewById(R.id.level084);
        level085 = (ScrollView) findViewById(R.id.level085);
        level086 = (ScrollView) findViewById(R.id.level086);
        level087 = (ScrollView) findViewById(R.id.level087);
        level088 = (ScrollView) findViewById(R.id.level088);
        level089 = (ScrollView) findViewById(R.id.level089);

        level090 = (ScrollView) findViewById(R.id.level090);
        level091 = (ScrollView) findViewById(R.id.level091);
        level092 = (ScrollView) findViewById(R.id.level092);
        level093 = (ScrollView) findViewById(R.id.level093);
        level094 = (ScrollView) findViewById(R.id.level094);
        level095 = (ScrollView) findViewById(R.id.level095);
        level096 = (ScrollView) findViewById(R.id.level096);
        level097 = (ScrollView) findViewById(R.id.level097);
        level098 = (ScrollView) findViewById(R.id.level098);
        level099 = (ScrollView) findViewById(R.id.level099);

        subject00 = (LinearLayout) findViewById(R.id.Subject00);
        subject01 = (LinearLayout) findViewById(R.id.Subject01);
        subject02 = (LinearLayout) findViewById(R.id.Subject02);
        subject03 = (LinearLayout) findViewById(R.id.Subject03);
        subject04 = (LinearLayout) findViewById(R.id.Subject04);
        subject05 = (LinearLayout) findViewById(R.id.Subject05);
        subject06 = (LinearLayout) findViewById(R.id.Subject06);
        subject07 = (LinearLayout) findViewById(R.id.Subject07);
        subject08 = (LinearLayout) findViewById(R.id.Subject08);
        subject09 = (LinearLayout) findViewById(R.id.Subject09);

        subject10 = (LinearLayout) findViewById(R.id.Subject10);
        subject11 = (LinearLayout) findViewById(R.id.Subject11);
        subject12 = (LinearLayout) findViewById(R.id.Subject12);
        subject13 = (LinearLayout) findViewById(R.id.Subject13);
        subject14 = (LinearLayout) findViewById(R.id.Subject14);
        subject15 = (LinearLayout) findViewById(R.id.Subject15);
        subject16 = (LinearLayout) findViewById(R.id.Subject16);
        subject17 = (LinearLayout) findViewById(R.id.Subject17);
        subject18 = (LinearLayout) findViewById(R.id.Subject18);
        subject19 = (LinearLayout) findViewById(R.id.Subject19);

        subject20 = (LinearLayout) findViewById(R.id.Subject20);
        subject21 = (LinearLayout) findViewById(R.id.Subject21);
        subject22 = (LinearLayout) findViewById(R.id.Subject22);
        subject23 = (LinearLayout) findViewById(R.id.Subject23);
        subject24 = (LinearLayout) findViewById(R.id.Subject24);
        subject25 = (LinearLayout) findViewById(R.id.Subject25);
        subject26 = (LinearLayout) findViewById(R.id.Subject26);
        subject27 = (LinearLayout) findViewById(R.id.Subject27);
        subject28 = (LinearLayout) findViewById(R.id.Subject28);
        subject29 = (LinearLayout) findViewById(R.id.Subject29);

        subject30 = (LinearLayout) findViewById(R.id.Subject30);
        subject31 = (LinearLayout) findViewById(R.id.Subject31);
        subject32 = (LinearLayout) findViewById(R.id.Subject32);
        subject33 = (LinearLayout) findViewById(R.id.Subject33);
        subject34 = (LinearLayout) findViewById(R.id.Subject34);
        subject35 = (LinearLayout) findViewById(R.id.Subject35);
        subject36 = (LinearLayout) findViewById(R.id.Subject36);
        subject37 = (LinearLayout) findViewById(R.id.Subject37);
        subject38 = (LinearLayout) findViewById(R.id.Subject38);
        subject39 = (LinearLayout) findViewById(R.id.Subject39);

        subject40 = (LinearLayout) findViewById(R.id.Subject40);
        subject41 = (LinearLayout) findViewById(R.id.Subject41);
        subject42 = (LinearLayout) findViewById(R.id.Subject42);
        subject43 = (LinearLayout) findViewById(R.id.Subject43);
        subject44 = (LinearLayout) findViewById(R.id.Subject44);
        subject45 = (LinearLayout) findViewById(R.id.Subject45);
        subject46 = (LinearLayout) findViewById(R.id.Subject46);
        subject47 = (LinearLayout) findViewById(R.id.Subject47);
        subject48 = (LinearLayout) findViewById(R.id.Subject48);
        subject49 = (LinearLayout) findViewById(R.id.Subject49);

        subject50 = (LinearLayout) findViewById(R.id.Subject50);
        subject51 = (LinearLayout) findViewById(R.id.Subject51);
        subject52 = (LinearLayout) findViewById(R.id.Subject52);
        subject53 = (LinearLayout) findViewById(R.id.Subject53);
        subject54 = (LinearLayout) findViewById(R.id.Subject54);
        subject55 = (LinearLayout) findViewById(R.id.Subject55);
        subject56 = (LinearLayout) findViewById(R.id.Subject56);
        subject57 = (LinearLayout) findViewById(R.id.Subject57);
        subject58 = (LinearLayout) findViewById(R.id.Subject58);
        subject59 = (LinearLayout) findViewById(R.id.Subject59);

        subject60 = (LinearLayout) findViewById(R.id.Subject60);
        subject61 = (LinearLayout) findViewById(R.id.Subject61);
        subject62 = (LinearLayout) findViewById(R.id.Subject62);
        subject63 = (LinearLayout) findViewById(R.id.Subject63);
        subject64 = (LinearLayout) findViewById(R.id.Subject64);
        subject65 = (LinearLayout) findViewById(R.id.Subject65);
        subject66 = (LinearLayout) findViewById(R.id.Subject66);
        subject67 = (LinearLayout) findViewById(R.id.Subject67);
        subject68 = (LinearLayout) findViewById(R.id.Subject68);
        subject69 = (LinearLayout) findViewById(R.id.Subject69);

        subject70 = (LinearLayout) findViewById(R.id.Subject70);
        subject71 = (LinearLayout) findViewById(R.id.Subject71);
        subject72 = (LinearLayout) findViewById(R.id.Subject72);
        subject73 = (LinearLayout) findViewById(R.id.Subject73);
        subject74 = (LinearLayout) findViewById(R.id.Subject74);
        subject75 = (LinearLayout) findViewById(R.id.Subject75);
        subject76 = (LinearLayout) findViewById(R.id.Subject76);
        subject77 = (LinearLayout) findViewById(R.id.Subject77);
        subject78 = (LinearLayout) findViewById(R.id.Subject78);
        subject79 = (LinearLayout) findViewById(R.id.Subject79);

        subject80 = (LinearLayout) findViewById(R.id.Subject80);
        subject81 = (LinearLayout) findViewById(R.id.Subject81);
        subject82 = (LinearLayout) findViewById(R.id.Subject82);
        subject83 = (LinearLayout) findViewById(R.id.Subject83);
        subject84 = (LinearLayout) findViewById(R.id.Subject84);
        subject85 = (LinearLayout) findViewById(R.id.Subject85);
        subject86 = (LinearLayout) findViewById(R.id.Subject86);
        subject87 = (LinearLayout) findViewById(R.id.Subject87);
        subject88 = (LinearLayout) findViewById(R.id.Subject88);
        subject89 = (LinearLayout) findViewById(R.id.Subject89);

        subject90 = (LinearLayout) findViewById(R.id.Subject90);
        subject91 = (LinearLayout) findViewById(R.id.Subject91);
        subject92 = (LinearLayout) findViewById(R.id.Subject92);
        subject93 = (LinearLayout) findViewById(R.id.Subject93);
        subject94 = (LinearLayout) findViewById(R.id.Subject94);
        subject95 = (LinearLayout) findViewById(R.id.Subject95);
        subject96 = (LinearLayout) findViewById(R.id.Subject96);
        subject97 = (LinearLayout) findViewById(R.id.Subject97);
        subject98 = (LinearLayout) findViewById(R.id.Subject98);
        subject99 = (LinearLayout) findViewById(R.id.Subject99);

        Bundle bundle = BrowseActivity.this.getIntent().getExtras();
        if(bundle!=null) {
            int subjectIndex = bundle.getInt("SubjectsIndex");
            switch (subjectIndex) {
                case 0:
                    mainParent = level00;
                    break;
                case 1:
                    mainParent = level01;
                    break;
                case 2:
                    mainParent = level02;
                    break;
                case 3:
                    mainParent = level03;
                    break;
                case 4:
                    mainParent = level04;
                    break;
                case 5:
                    mainParent = level05;
                    break;
                case 6:
                    mainParent = level06;
                    break;
                case 7:
                    mainParent = level07;
                    break;
                case 8:
                    mainParent = level08;
                    break;
                case 9:
                    mainParent = level09;
                    break;
                default:
                    mainParent = null;
                    break;
            }

            if (mainParent != null) {
                mainParent.setVisibility(View.VISIBLE);
            }

            subject00.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level000;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level001;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject02.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level002;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level003;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject04.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level004;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject05.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level005;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject06.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level006;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject07.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level007;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject08.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level008;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject09.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level009;
                    parent.setVisibility(View.VISIBLE);
                }
            });

            subject10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level010;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level011;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level012;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level013;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level014;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level015;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level016;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level017;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level018;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level019;
                    parent.setVisibility(View.VISIBLE);
                }
            });

            subject20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level020;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level021;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level022;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject23.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level023;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject24.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level024;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject25.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level025;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject26.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level026;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject27.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level027;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject28.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level028;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject29.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level029;
                    parent.setVisibility(View.VISIBLE);
                }
            });

            subject30.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level030;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject31.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level031;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject32.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level032;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject33.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level033;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject34.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level034;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject35.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level035;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject36.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level036;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject37.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level037;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject38.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level038;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject39.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level039;
                    parent.setVisibility(View.VISIBLE);
                }
            });

            subject40.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level040;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject41.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level041;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject42.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level042;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject43.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level043;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject44.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level044;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject45.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level045;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject46.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level046;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject47.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level047;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject48.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level048;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject49.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level049;
                    parent.setVisibility(View.VISIBLE);
                }
            });

            subject50.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level050;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject51.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level051;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject52.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level052;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject53.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level053;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject54.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level054;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject55.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level055;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject56.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level056;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject57.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level057;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject58.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level058;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject59.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level059;
                    parent.setVisibility(View.VISIBLE);
                }
            });

            subject60.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level060;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject61.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level061;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject62.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level062;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject63.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level063;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject64.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level064;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject65.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level065;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject66.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level066;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject67.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level067;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject68.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level068;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject69.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level069;
                    parent.setVisibility(View.VISIBLE);
                }
            });

            subject70.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level070;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject71.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level071;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject72.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level072;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject73.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level073;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject74.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level074;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject75.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level075;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject76.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level076;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject77.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level077;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject78.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level078;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject79.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level079;
                    parent.setVisibility(View.VISIBLE);
                }
            });

            subject80.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level080;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject81.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level081;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject82.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level082;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject83.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level083;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject84.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level084;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject85.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level085;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject86.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level086;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject87.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level087;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject88.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level088;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject89.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level089;
                    parent.setVisibility(View.VISIBLE);
                }
            });

            subject90.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level090;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject91.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level091;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject92.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level092;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject93.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level093;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject94.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level094;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject95.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level095;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject96.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level096;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject97.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level097;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject98.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level098;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject99.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level099;
                    parent.setVisibility(View.VISIBLE);
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        if (parent != null) {
            if (parent.getVisibility() == View.VISIBLE) {
                parent.setVisibility(View.GONE);
                mainParent.setVisibility(View.VISIBLE);
            } else {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }
}
