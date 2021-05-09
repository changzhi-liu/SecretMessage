import random
import string
import time
import datetime
import os

def fake_inserts(users:dict, num_of_msgs=400, string_size=20):
    data = []
    for i in range(num_of_msgs):
        temp = users.copy()
        sender_id, sender = random.choice(list(temp.items()))
        temp.pop(sender_id)
        receiver_id, receiver = random.choice(list(temp.items()))
        content = ''.join(random.SystemRandom().choice(string.ascii_letters + string.digits ) for _ in range(string_size))
        validation = 0
        
        ts = time.time()
        send_time = datetime.datetime.fromtimestamp(ts).strftime('%Y-%m-%d %H:%M:%S')

        Q = lambda x: '\"' + x + '\"'

        data.append((i, Q(sender), Q(receiver), sender_id, receiver_id, Q(content), validation, Q(send_time)))
    return data

def generate_mysql_insert(data, file_path="./fake_inserts.sql"):
    cmd_prefix = "INSERT INTO  message VALUES "
    all_cmds = []
    for row in data:
        row_str = list(map(str, row))
        cmd = cmd_prefix + '(' + ', '.join(row_str) + ');'
        all_cmds.append(cmd)
    with open(file_path, 'w+') as file:
        file.writelines('\n'.join(all_cmds))



if __name__ == "__main__":
    print(os.getcwd())
    users = {0:"a", 1:"b", 2:"c"}
    data = fake_inserts(users)
    generate_mysql_insert(data)