#! /usr/local/bin/python3


"""
Author: Omar Iriskic
@contact:
    https://omaririskic.com/
    https://github.com/OMKE
Date: 22 - 04 - 2020 12:04
"""

import os
import sys
import pip
import argparse
import json
import re
from pprint import pprint

"""
install
@desc:
    Installs and imports jinja2
@return: void -
"""


"""
install_jinja
@desc:
    If user doesn't have jinja2 installed with pip, it installs automatically on first run of this script, else it imports it
@return: void -
"""


def install_jinja():
    import importlib
    try:
        importlib.import_module('jinja2')
    except ImportError:
        from pip._internal import main
        main.main(['install', 'jinja2'])
    finally:
        globals()['jinja2'] = importlib.import_module('jinja2')


"""
install_javalang
@desc:
    If user doesn't have javalang installed with pip, it installs automatically on first run of this script, else it imports it
@return: void -
"""


def install_javalang():
    import importlib
    try:
        importlib.import_module('javalang')
    except ImportError:
        from pip._internal import main
        main.main(['install', 'javalang'])
    finally:
        globals()['javalang'] = importlib.import_module('javalang')


def find_file(file_name):
    for root, dirs, files in os.walk(os.path.abspath(os.getcwd())):
        if file_name in files:
            return root, os.path.join(root, file_name)


"""
CLI
@desc:
    Main class for getting the arguments and instantiating a generator
"""


class CLI:
    # CLI COLORS
    HEADER = '\033[95m'
    OKBLUE = '\033[94m'
    OKGREEN = '\033[92m'
    WARNING = '\033[93m'
    FAIL = '\033[91m'
    ENDC = '\033[0m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'

    SCRIPT_DIR = os.path.dirname(os.path.realpath(__file__))

    def __init__(self):
        self.status = False
        self.generator = None
        # Instantiate argument parser
        self.arg_parser = argparse.ArgumentParser()
        self.__arg_parser_add_arguments()
        self.args = self.arg_parser.parse_args()
        self.__arguments_actions()

    # def show_application_root(self):

    """
    __parser_add_arguments
    @desc:
        Adds arguments to CLI
    @return:  void -
    """

    def __arg_parser_add_arguments(self):
        self.arg_parser.add_argument(
            '--main', '-m', help="Set project root class file name without extension .java")

        self.arg_parser.add_argument(
            '--reset', '-r', action="store_true", help="Resets the current config")
        self.arg_parser.add_argument(
            '--generate', '-g', help="Used with --model=EntityFileName and generates DTO, Repository, Service and Controller based of model", action="store_true")
        self.arg_parser.add_argument(
            '--model', '-md', help="Model/Entity file name")
        self.arg_parser.add_argument(
            '--properties', '-p', nargs='+', help="List of model properties", type=str)

        # Parse the given arguments
        self.arg_parser.parse_args()

    def __arguments_actions(self):
        if self.args.reset:
            self.__delete_config()
            return

        if not self.args.main:
            self.__read_config()

        if self.args.main:
            self.__make_config()

        if self.args.generate and self.args.model and self.args.properties:
            model_to_parse = find_file(self.args.model + ".java")
            if model_to_parse is not None and self.status:
                """
                # TODO
                @desc:
                    Parse java file and get all the fields and methods
                """

                model_file = open(model_to_parse[1])
                model_class = javalang.parse.parse(model_file.read())
                model_file.close()
                model_name = model_class.types[0].name
                # @var Instantiate generator
                self.generator = Generator(self.project_root,
                                           model_name, self.package, self.args.properties)
                self.start_generator()
            else:
                print(f"{CLI.FAIL}✗ Model is not found")
                return

    def __read_config(self):
        try:
            with open(CLI.SCRIPT_DIR + "/config.json", "r") as _file:
                self.config = json.load(_file)
                self.project_root = self.config['project_root']
                self.package = self.config['package_name']
                print(f"{CLI.HEADER}✓ Current project folder: {self.project_root}")
                print(f"{CLI.HEADER}✭ Root package: {self.package}")
                self.status = True
        except IOError:
            print(
                f"{CLI.FAIL}✗ Project root is not set")

    def __make_config(self):
        config = {}
        searched_file = find_file(self.args.main + ".java")

        if searched_file:

            """
            @desc:
                reading and parsing java code
            """

            java_file = open(searched_file[1])
            java_class = javalang.parse.parse(java_file.read())
            java_file.close()

            package = java_class.package.name

            # @var project_root - root directory of selected project
            project_root = searched_file[0] + "/"
            # @var root_class - project root class like App or SpringApplication
            main_class = searched_file[1].split("/")[-1]

            config['project_root'] = project_root
            config['main_class'] = main_class
            config['package_name'] = package

            # java_file = open(project_root + "model/Firma.java").read()
            # tree = javalang.parse.parse(java_file)
            # print(tree.package.name)

            """
            @desc:
                Save to the json file so user doesn't have to pass --main argument every time
            """

            with open(CLI.SCRIPT_DIR + '/config.json', 'w', encoding='utf-8') as _file:
                json.dump(config, _file, indent=4)

            self.project_root = project_root
            self.package = package

            print(
                f"{CLI.OKGREEN}✓ Project main class found and saved to config file")
            self.status = True
        else:
            print(f"{CLI.FAIL}✗ Project main class not found.")
            self.__read_config()

    def __check_if_config_exists(self):
        try:
            f = open(CLI.SCRIPT_DIR + "/config.json")
            return True
        except IOError:
            return False
        finally:
            f.close()

    def start_generator(self):
        self.generator.start()

    def __delete_config(self):
        if os.path.isfile(CLI.SCRIPT_DIR + "/config.json"):
            os.remove(CLI.SCRIPT_DIR + "/config.json")
            print(
                f"{CLI.OKGREEN}✓ Config reseted")
        else:
            print(
                f"{CLI.FAIL}✗ There wasn't config to reset")


"""
Template
@desc:
    Base class for all templates
"""


class Template:
    def __init__(self, model_name, package):
        self.model_name = model_name
        self.package = package
        self.output = ""


"""
DTO
@desc:
    DTO Template
"""


class DTO(Template):
    """
    @attributes:
        model_name - Name of the model out of which DTO file should be created
        package - main package
        properties - list of properties that model has, passed through cli with flag --properties/-p, separated with white space
    """

    def __init__(self, model_name, package, properties):
        super().__init__(model_name, package)
        self.name = model_name + "DTO"
        self.properties = properties


"""
Service
@desc:
    Service Template
"""


class Service(Template):
    """
    @attributes:
        model_name - Name of the model out of which Service file should be created
        package - main package
        repository_name - name of the repository that should get DB records
    """

    def __init__(self, model_name, package, repository_name):
        super().__init__(model_name, package)
        self.name = model_name + "Service"
        self.repository = repository_name


"""
Repositry
@desc:
    Repository Template
    By default it generates a CrudRepository
    todo
    - if -ps argument is passed, it should create PagingAndSortingRepository
"""


class Repository(Template):
    def __init__(self, model_name, package):
        super().__init__(model_name, package)
        self.name = model_name + "Repository"


"""
Controller
@desc:
    Controller Template
    By default it generates a @Controller class,
    todo
    - if -rs argument is passed, it should create @RestController
    todo
    - if -url argument is passed, it should add custom path to RequestMapping
"""


class Controller(Template):
    def __init__(self, model_name, model_getters, package, service_name):
        super().__init__(model_name, package)
        self.name = model_name + "Controller"
        self.service_name = service_name
        self.service_var = service_name[0].lower() + service_name[1:]
        self.model_var = model_name[0].lower() + model_name[1:]
        self.model_getters = model_getters


class Generator:
    SCRIPT_DIR = os.path.dirname(os.path.realpath(__file__))

    def __init__(self, project_root, model_name, package, properties):
        self.project_root = project_root
        self.model_name = model_name
        self.package = package
        self.__set_types(properties)

    """
    __set_types
    @desc:
        Populates a list with dictionaries of structure key,name
    @params:
        properties - a list of properties,
    @return: void -
    """

    def __set_types(self, properties):
        self.properties = []
        self.methods = {
            "getters": [],
        }
        for i in properties:
            try:
                property_type, property_name = i.split(" ")
                self.properties.append({
                    "type": property_type,
                    "name": property_name
                })
                self.methods["getters"].append(
                    "get"+property_name[0].upper() + property_name[1:])
            except ValueError:
                print(
                    f"{CLI.FAIL}✗ Missing type or property name, ignoring...")
                continue

    def start(self):
        # Generate files out of templates
        self.generate_dto()
        self.generate_repository()
        self.generate_service()
        self.generate_controller()

        # Save files to project
        self.save_files()

    def generate_dto(self):
        with open(Generator.SCRIPT_DIR + '/templates/dto.java.j2') as _file:
            template = jinja2.Template(_file.read())

        self.dto = DTO(self.model_name, self.package, self.properties)

        self.dto.output = template.render(
            dto=self.dto)

    def generate_repository(self):
        with open(Generator.SCRIPT_DIR + "/templates/repository.java.j2") as _file:
            template = jinja2.Template(_file.read())

        self.repository = Repository(self.model_name, self.package)
        self.repository.output = template.render(repository=self.repository)

    def generate_service(self):
        with open(Generator.SCRIPT_DIR + "/templates/service.java.j2") as _file:
            template = jinja2.Template(_file.read())

        self.service = Service(
            self.model_name, self.package, self.repository.name)
        self.service.output = template.render(service=self.service)

    def generate_controller(self):
        with open(Generator.SCRIPT_DIR + "/templates/controller.java.j2") as _file:
            template = jinja2.Template(_file.read())

        self.controller = Controller(
            self.model_name, self.methods["getters"], self.package, self.service.name)
        self.controller.output = template.render(controller=self.controller)

    def save_dto(self):
        path = self.project_root + "/dtos/" + self.dto.name + ".java"
        with open(path, 'w') as _dto_file:
            _dto_file.write(self.dto.output)

        print(
            f"{CLI.OKGREEN}✓ Generated {self.model_name}DTO successfully")

    def save_repository(self):
        path = self.project_root + "/repositories/" + self.repository.name + ".java"
        with open(path, 'w') as _repo_file:
            _repo_file.write(self.repository.output)

        print(
            f"{CLI.OKGREEN}✓ Generated {self.model_name}Repository successfully")

    def save_service(self):
        path = self.project_root + "/services/" + self.service.name + ".java"
        with open(path, 'w') as _service_file:
            _service_file.write(self.service.output)

        print(
            f"{CLI.OKGREEN}✓ Generated {self.model_name}Service successfully")

    def save_controller(self):
        path = self.project_root + "/controllers/" + self.controller.name + ".java"
        with open(path, 'w') as _controller_file:
            _controller_file.write(self.controller.output)

        print(
            f"{CLI.OKGREEN}✓ Generated {self.model_name}Controller successfully")

    def save_files(self):
        self.save_dto()
        self.save_repository()
        self.save_service()
        self.save_controller()


if __name__ == '__main__':
    install_jinja()
    install_javalang()
    CLI()
