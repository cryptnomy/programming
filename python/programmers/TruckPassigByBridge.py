DUMMY_TRUCK = 0

class Bridge(object):
    def __init__(self, length, weight):
        self._max_length = length
        self._max_weight = weight
        self._queue = []
        self._current_weight = 0

    def push(self, truck):
        next_weight = self._current_weight + truck
        if next_weight <= self._max_weight and len(self._queue) < self._max_length:
            self._queue.append(truck)
            self._current_weight = next_weight
            return True
        else:
            return False
    
    def pop(self):
        item = self._queue.pop(0)
        self._current_weight -= item
        return item

    def __len__(self):
        return len(self._queue)

    def __repr__(self):
        return 'Bridge({}/{}: [{}])'.format(
            self._current_weight, self._max_weight, list(self._queue))
    
def solution(bridge_length, weight, truck_weights):
    bridge = Bridge(bridge_length, weight)
    count = 0
    
    for _ in range(bridge_length):
        bridge.push(DUMMY_TRUCK)
    
    while truck_weights:
        bridge.pop()

        if bridge.push(truck_weights[0]):
            truck_weights.pop(0)
        else:
            bridge.push(DUMMY_TRUCK)
        count += 1
    
    while bridge:
        bridge.pop()
        count += 1

    return count

if __name__ == '__main__':
    # bridge_length     weight  truck_weights                    return
    # 2                 10      [7,4,5,6]                        8
    # 100               100     [10]                             101
    # 100               100     [10,10,10,10,10,10,10,10,10,10]	 110
    bridge_length = 100
    weight = 100
    truck_weights = [10]
    
    ans = solution(bridge_length, weight, truck_weights)

    print(ans)

'''
def solution(bridge_length, weight, truck_weights):
    time = 0
    DUMMY_TRUCK = 0
    bridge = [DUMMY_TRUCK] * bridge_length

    while truck_weights:
        bridge.pop(0)
        // sum() function is the main cause for slower execution time
        // sum(bridge) information needs storing
        if sum(bridge) + truck_weights[0] <= weight:
            bridge.append(truck_weights.pop(0))
        else:
            bridge.append(DUMMY_TRUCK)
        time += 1

    while bridge:
        bridge.pop(0)
        time += 1
        
    return time
'''