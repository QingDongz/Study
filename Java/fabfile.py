
""" 适用于 centos7 amd64  """
from fabric.api import env, run, local, warn_only
from fabric.operations import sudo
from fabric.colors import *
import shutil

GIT_REPO = "https://github.com/bpzj/linux.conf"
repo = "git@120.79.47.191:/home/git/repo.git"
repo_folder = '/home/git/repo.git'
data_folder = '/home/bpzj/data/repo/'
local_repo = r'E:\repo'
local_proj_folder = r'E:\OneDrive\GitHubCode\Study\Java'
project = r'ssmcrud'
env.user = 'root'
# 使用 本机私钥登录
env.key_filename = '~/.ssh/id_rsa'
env.hosts = ['120.79.47.191']
env.port = '22'
# 跳过错误
env.warn_only = True

# env.hosts = ['www.lqtblog.com']
# env.port = '29183'
# env.password = '4260'     # 使用密码


def deptomcat():
    # 复制项目文件到 git仓库文件夹
    copyfile(local_proj_folder, local_repo, project)
    local("""cd %s && git add . && git commit -m "new" && git push""" % local_repo)
    run("""cd {} && git pull """.format(data_folder))
    # 手动拼接出 服务器上项目的路径
    remote_repo = data_folder + project
    sudo('cd %s && mvn clean package' % remote_repo)
    # 自己手动拼接字符串，拼出war包的路径
    war_path = remote_repo + r"/target/" + project + ".war"
    # 注意空格
    sudo('cp -rf ' + war_path + ' /usr/local/tomcat/webapps/')
    sudo('systemctl restart tomcat')
    sudo('nginx -s reload')


def depresin():
    # 复制项目文件到 git仓库文件夹
    copyfile(local_proj_folder, local_repo, project)
    local("""cd %s && git add . && git commit -m "new" && git push""" % local_repo)
    run("""cd {} && git pull """.format(data_folder))
    # 手动拼接出 服务器上项目的路径
    remote_repo = data_folder + project
    sudo('cd %s && mvn clean package' % remote_repo)
    # 自己手动拼接字符串，拼出war包的路径
    war_path = remote_repo + r"/target/" + project + ".war"
    # 注意空格
    sudo('cp -rf ' + war_path + ' /usr/local/resin/webapps/')


def copyfile(parent_src_dir, parent_dst_dir, proj):
    """
    用来复制一个项目到指定文件夹
    :param parent_src_dir: 项目文件夹的父文件夹
    :param parent_dst_dir: 目标文件夹
    :param proj: 项目名称，也就是项目文件夹的名称
    :return:
    """
    # 用 上级目录 join 项目名称，获得在本地复制时真正的源地址和目标地址
    src_dir = os.path.join(parent_src_dir, proj)
    dst_dir = os.path.join(parent_dst_dir, proj)

    # 先删除项目的目标文件夹
    for root, dirs, files in os.walk(parent_dst_dir):
        if proj in dirs:
            shutil.rmtree(dst_dir)

    # 先复制 src 文件夹
    shutil.copytree(os.path.join(src_dir, "src"), os.path.join(dst_dir, "src"))
    # 再复制 pom.xml 文件
    shutil.copy(os.path.join(src_dir, "pom.xml"), os.path.join(dst_dir, "pom.xml"))

