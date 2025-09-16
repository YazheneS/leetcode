/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution 
{
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2)
    {
        ListNode *a= l1, *b=l2;
        
        int arr[100], i=0, carry=0;
        while(a||b||carry)
        {
            int aval = (a ? a->val : 0);
            int bval = (b ? b->val : 0);
            int sum=aval+bval+carry;
            arr[i] = sum % 10;
            carry = sum / 10;
            i++;
            if(a) a =a->next;
            if(b) b =b->next;
        }
        ListNode* head = nullptr;
        for (i=i-1; i >= 0; i--) 
        {
            ListNode* node = new ListNode(arr[i]); 
            node->next = head;                     
            head = node;
        }
        return head;

    }
};