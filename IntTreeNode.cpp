// This class provides a public Node object containing an int value for data
// It can be used for any problems requiring int trees

#ifndef INTTREENODE_CPP
#define INTTREENODE_CPP

using namespace std;

class IntTreeNode {

  public: 
  //--------------------------------------------------------Public member fields
  int value;
  IntTreeNode* left;
  IntTreeNode* right;

  //-------------------------------------------------------Public member methods
  IntTreeNode() {
    this->value = 0;
    this->left = nullptr;
    this->right = nullptr;
  }

  IntTreeNode(int v) {
    this->value = v;
    this->left = nullptr;
    this->right = nullptr;
  }

  IntTreeNode(int v, IntTreeNode* l, IntTreeNode* r) {
    this->value = 0;
    this->left = l;
    this->right = r;
  }
};
#endif