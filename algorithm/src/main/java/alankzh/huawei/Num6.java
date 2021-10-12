package alankzh.huawei;

/**
 ACM编程题 [编程题|平均分54.90099分|23人正确/202人做题|提交0次] 得分：0 / 200
 标题：德州扑克 | 时间限制：1秒 | 内存限制：262144K | 语言限制：不限
 五张牌，每张牌由牌大小和花色组成，牌大小2~10、J、Q、K、A，牌花色为红桃、黑桃、梅花、方块四种花色之一。 判断牌型:
 牌型1，同花顺：同一花色的顺子，如红桃2红桃3红桃4红桃5红桃6。
 牌型2，四条：四张相同数字 + 单张，如红桃A黑桃A梅花A方块A + 黑桃K。
 牌型3，葫芦：三张相同数字 + 一对，如红桃5黑桃5梅花5 + 方块9梅花9。
 牌型4，同花：同一花色，如方块3方块7方块10方块J方块Q。
 牌型5，顺子：花色不一样的顺子，如红桃2黑桃3红桃4红桃5方块6。
 牌型6，三条：三张相同 + 两张单。
 牌型7，其他。
 说明：
 1）五张牌里不会出现牌大小和花色完全相同的牌。
 2）编号小的牌型较大，如同花顺比四条大，依次类推。
 3）包含A的合法的顺子只有10 J Q K A和A 2 3 4 5，类似K A 2 3 4的序列不认为是顺子。
 输入描述:
 输入由5行组成，每行为一张牌大小和花色，牌大小为2~10、J、Q、K、A，花色分别用字符H、S、C、D表示红桃、黑桃、梅花、方块。
 输出描述:
 输出牌型序号，5张牌符合多种牌型时，取最大的牌型序号输出。
 示例1
 输入
 4 H
 5 S
 6 C
 7 D
 8 D
 输出
 5
 说明
 4 5 6 7 8构成顺子，输出5
 示例2
 输入
 9 S
 5 S
 6 S
 7 S
 8 S
 输出
 1
 说明
 既是顺子又是同花，输出1，同花顺
 */
public class Num6 {
}