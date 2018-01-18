import os
import shutil


# 删除 符合规则的 文件夹


# 遍历当前文件夹下第一层文件
def traversal_first_layer():
    """
    在本 Python 脚本所在的文件夹遍历，只遍历第一层
    """
    # 获得此脚本文件所在目录
    root = os.getcwd()

    # 遍历当前目录下的文件和文件夹，只有第一层，包括文件和文件夹
    dirs = os.listdir()
    copy_dirs = dirs[:]

    # 去掉文件，在 copy_dirs 列表 中只保留 文件夹
    for path in dirs:
        if os.path.isfile(os.path.join(root, path)):
            copy_dirs.remove(path)
    print(copy_dirs)

    # 逐行打印 当前目录下的 文件夹
    print("当前目录下有以下文件夹：")
    for directory in copy_dirs:
        print("\t\t"+directory)

    # ********************************************
    # 从键盘输入获取想要部署的项目（文件夹），并检验
    while True:
        project = input("请输入想要部署的文件夹(项目):\n")
        if project in copy_dirs:
            print("\n(◔◡◔)有这个项目，即将部署\n")
            return project
        else:
            print("\n(◔◡◔) 好像没有有这个项目\n")


a = traversal_first_layer()
print("a="+a)


