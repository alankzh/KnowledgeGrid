package alankzh.introductiontoalgorithms.datastucture;

import java.util.Random;

/**
 * 查找类数据结构一般分为两种: 各种类型的平衡树、hash表
 * 除此之外，就是容易实现的跳跃表
 * 原论文:
 * https://libgen.ggfwzs.net/book/18770477/648ff9/?wrongHash
 * 教程:
 * https://juejin.cn/post/6844903446475177998
 *
 *  skiplist和各种平衡树（如AVL、红黑树等）的元素是有序排列的，而哈希表不是有序的。
 * 因此，在哈希表上只能做单个key的查找，不适宜做范围查找。
 * 所谓范围查找，指的是查找那些大小在指定的两个值之间的所有节点。
 *
 *  在做范围查找的时候，平衡树比skiplist操作要复杂。
 * 在平衡树上，我们找到指定范围的小值之后，还需要以中序遍历的顺序继续寻找其它不超过大值的节点。
 * 如果不对平衡树进行一定的改造，这里的中序遍历并不容易实现。
 * 而在skiplist上进行范围查找就非常简单，只需要在找到小值之后，对第1层链表进行若干步的遍历就可以实现。
 *
 *  平衡树的插入和删除操作可能引发子树的调整，逻辑复杂，而skiplist的插入和删除只需要修改相邻节点的指针，操作简单又快速。
 *
 *  从内存占用上来说，skiplist比平衡树更灵活一些。
 * 一般来说，平衡树每个节点包含2个指针（分别指向左右子树），而skiplist每个节点包含的指针数目平均为1/(1-p)，
 * 具体取决于参数p的大小。如果像Redis里的实现一样，取p=1/4，那么平均每个节点包含1.33个指针，比平衡树更有优势。
 *
 *  查找单个key，skiplist和平衡树的时间复杂度都为O(log n)，大体相当；
 * 而哈希表在保持较低的哈希值冲突概率的前提下，查找时间复杂度接近O(1)，性能更高一些。
 * 所以我们平常使用的各种Map或dictionary结构，大都是基于哈希表实现的。
 *
 *  从算法实现难度上来比较，skiplist比平衡树要简单得多。
 *
 */
public class SkipList {

    // 最大层级
    private int maxLevel = 32;
    // 增长概率
    private double p = 0.25;

    /**
     *  与redis中skipList的随机level实现一致
     *  每个node至少层级为1，而具有下一层级的概率为p
     **/
    private int randomLevel() {
        int level = 1;
        Random random = new Random();
        if (random.nextDouble() < p && level < maxLevel) {
            level ++;
        }
        return level;
    }


}
