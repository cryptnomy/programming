import sys

sys.stdin.readline().rstrip()
cards_list = sys.stdin.readline().strip().split()
sys.stdin.readline().rstrip()
cmp_list = sys.stdin.readline().strip().split()

cards_dict = {}
for card in cards_list:
    if card in cards_dict:
        cards_dict[card] += 1
    else:
        cards_dict[card] = 1

print(' '.join(str(cards_dict[cmp]) if cmp in cards_dict else '0' for cmp in cmp_list))