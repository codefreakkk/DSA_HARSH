package contests.leetcode.WeeklyContest326;

public class ProblemC {
    public static int minimumPartition(String s, int k) {
        int count = 1, size = s.length();
        long n = 0;

        for (int i = 0; i < size; i++) {
            long current = s.charAt(i) - '0';
            if (n * 10 + current > k) {
                count++;
                n = 0;
            }
            n = n * 10 + current;
            if (n > k)
                return -1;
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "261573452571639888681178462747217612125795998492814983234269339568223339597834529784788669821196181696183271979175498611981514475959432834658752862451582545627979656828187489892523958591824578667888364432314787834297597526566697784865232872737128812174866128438453773253756886593349651673651719597858734935683136197871275346544344759386221887871461361349656787459677984344397417357365133679982773131112937934334791766991412199334842568291812299361234326865137451117694111755168755878978627144722474424273786753256827791339387837552334574673112786774751257374299673371582753877385871143358948128114927633662578196531255468685454816717837437136341522691169784187539999552241347566332771866597491619322838912762111529915558392323272749317317264419866922168683547345375787676849886966533872165343995955812577336899563395852678158387628391293398225484975694644231258765353216129445686738515867296832137876132833157963787853258495722762363267567766219611942576448994211618397689419371746361176567597896468312383768212717684678277754341544465815792566969763913522175168166133442597873794819877419822456292341738158999579669518257128145434548927558523295899314145119573651128449243653122748849122391132849419766242116915169671614584759916782112986745762952197933149198371524636453296654929957716971586519395198976229518386512913581488661188712516667231762117849396122456764487762874664651852689657517743485751538949632197272393149582794374821685957644686735546775553136881226444134611815989296953173279461559539529527951893152617158122939547472316828462574615127336738924161634927635845695652247728568872895718164491246649765931249921931925439191924984728373765335324523377231267277589949791115619421219868588764593396756929253387518183465436981145429245847769747895733373694999558545944263852372542384238662129733764118317194691835661773983652976815817431522437223854669783934738545787958468241648513354668949858511844114134283691362566978581796599836531846782669132921426192234871663268339456732869381624623514633936916451358213624391666283733742155844738613128655787325828586565535271599963223128627546132523264112222318366493951272213544292163451269177687547266969962964529387882297149122246974291758774376469231922925284525222624539856372196793261888989458914895446487846833933337312559976729188951194299868232182988788517699439466641246695458178352478589633491718969873357426822351413191772836879923373896631418744214936856729959723624699624359178662617684469554734576995576299425585575624767919179533544631535511384983851225222349159849219349838397345779914349674241637368485661918859498199545163381519652539928812878268743359198461144258761872676646428822798892892124244447262889975124136654859344989541246437145488975843418248898966851465775117291272669125211684797694344858694576985296861283741155694898186878923293623757312257398247276168626575852933828728228852495656622133241465779554446825535478322586351728188834238647929747969156933195888192767693181625679646723173497974716946463124688193958462567299286313372518429939915947847958176372214312168442251524977689396296344228661643162724539737715739236459514295639968759694223151444172265477119125158416481119236315597873179668746993954211957489718363779561568463511933683165852586264824558981999212635353678388742193995529334678624846175457752723275526385855741563672982378834626136265825141772527113396252918155996331844977654845829216195325494867569848628817782766277533312683992733555644394421353136493579121749317528358999129511717145293397497129838312343965861267936612533615154812815268882169841227876526969342426986111139949932612547198322748675398447163142959816424482993423758675766367343518333621557371123552687378254736918828391455351424839885123435753182578298341441866337266675686141578367337847456274735192621399118951938556785832466186714911122328161833585585494142483241438298896143281989852933248762724888518293896444546293112644993859481913137962132743612937297539177986418561173296361573358374633588417416794228117272752793986145878489777616534954419193576383178283691854446381266548461834896652549939719568223358374516493188459514657528379879573737917239148365675344634412634568187572328776656586758241164522981449341594595349698581664678574435562794175196394735339646548174816479481637519575891166261642619591356421535126588814562675822446446368848945925418515725851317165984476573292253926865645623688658585349983775544274851398553674593973928931519945684277224893147754861169627218965784614843985889276416392494616114629782767966624223244764225893827289129266663649137998931348589755246753123678568944937254142786795474489663186925598523122971182625492138596595557261987624961372631524542224252934727842671246352537299759924231568287138513737221638616618498126564893535255898464763645557659323526829746175943546679789867942293716239212438275565394122627959186481666366417972367112734314999743218734744777481962311696925687976537167996234262173749529145546233239517421762591346368954915877365635996958511192346989482616639925614119792278495357323559744315515371592821916322273626262297589158719771224738454859311562598786599528631249615818633573598319911673814418978932352511816533147718783615311741945517338283881646947347557928557889738698871593941465839692793732789371791245966242897195835747398157761531753674861319564644533921144423682818178823428144683694685877596324178962231961272565793113575946985614434914311477169757941583577634146476446725814337172375147284721417847628293235155999243258781215166924545119687979269965646382927651858974278862179857127951451252224157124438887629342982419195462321119696112886211121993721782735212724446457724212959852271561465798747764379571816526513865586282964657418932314674552381341632138317846422359625976367851655554518899435174744177435795772784848129917167721849464222499292171181772962451596891452675919797558458963314976422841893742392343169278649437693621428743664228358722882278526521398756242342447568785978111297258252316322347565547936233452181917559489922482688323776273943195297238495812783963871385819941565641469342274454683855321668356425452265826675449558721292236177756768787721761636648371721451133774467388637274416647427617323839348964553926636781637275894522566248334879316752137795726219837679622751163983947444315933238381874132788591157213954";
        int k = 784955370;
        System.out.println(minimumPartition(s, k));
    }
}
