import os
import shutil


# 删除 符合规则的 文件夹，
for root, dirs, files in os.walk('./'):
    for dir_name in dirs:
        # print(dirs)
        # print(files)
        if dir_name.endswith(".idea"):
            # os.remove(os.path.join(root, dir_name))
            shutil.rmtree(os.path.join(root, dir_name))


# 删除 符合规则的 文件，
for root, dirs, files in os.walk('./'):
    for dir_name in files:
        if dir_name.endswith(".idea"):
            os.remove(os.path.join(root, dir_name))



