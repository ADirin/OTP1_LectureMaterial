# Virtual Machines (VMs)

Virtual machines (VMs) are software-based emulations of physical computers. They allow you to run multiple operating systems (OSes) simultaneously on a single physical machine, known as the host machine. Each VM operates independently, with its own virtual hardware resources, including CPU, memory, storage, and network interfaces.

## Example: Running Windows on a Mac

Suppose you have a Mac computer and need to run Windows applications for a specific task. Instead of purchasing a separate Windows PC, you can use virtualization software like VMware Fusion, Parallels Desktop, or VirtualBox to create a Windows VM on your Mac.

1. **Installation:** Install the virtualization software on your Mac.

2. **Create a VM:** Open the virtualization software and create a new VM. Specify the OS type and version (e.g., Windows 10), allocate resources (CPU cores, RAM), and create a virtual hard disk.

3. **Install Windows:** Insert the Windows installation disc or ISO file into the VM and start it. Follow the on-screen instructions to install Windows on the VM, just as you would on a physical PC.

4. **Configuration:** After installation, configure the VM settings such as networking, display resolution, and shared folders between the host and guest OS.

5. **Usage:** Now, you can run Windows applications directly within the VM on your Mac. Switch between the host (Mac OS) and guest (Windows) seamlessly.

## Benefits of VMs

- **Resource Consolidation:** VMs allow efficient utilization of physical hardware by running multiple OSes and applications on a single machine.

- **Isolation:** Each VM is isolated from others, providing a secure environment for testing, development, and running potentially unsafe software.

- **Flexibility:** VMs can be easily migrated, cloned, or snapshot for backup and disaster recovery purposes.

- **Cost Savings:** Instead of purchasing separate hardware for each OS or application, VMs enable cost-effective IT infrastructure by leveraging existing resources.

#### Conclusion

Virtual machines provide a powerful and flexible solution for running multiple operating systems and applications on a single physical machine. Whether for development, testing, or production environments, VMs offer benefits such as resource consolidation, isolation, flexibility, and cost savings.

This example demonstrates how VMs can be used to run Windows applications on a Mac, showcasing the versatility and utility of virtualization technology.

-------------------------------------------


# How to Add a Virtual Machine

To add a virtual machine (VM), you typically need virtualization software installed on your computer such as VirtualBox, VMware, or Hyper-V. Here's a general guide on how to add a virtual machine using VirtualBox:

## Install VirtualBox
If you haven't already, download and install VirtualBox from the official website, such as [Oracle VM VirtualBox](https://www.virtualbox.org/).

## Open VirtualBox
Launch the VirtualBox application on your computer.

## Create a New Virtual Machine
1. Download the Ubuntu ISO from [Ubuntu Download](https://ubuntu.com/download).
2. Open VirtualBox and click on `New` to create a new virtual machine.
3. Follow the wizard to set up the new virtual machine:
   - Provide a name for your VM.
   - Choose the type and version of the operating system you'll be installing on the VM.
   
## Allocate Memory (RAM)
Choose the amount of RAM to allocate to the virtual machine. Ensure that you allocate enough memory for the operating system and any applications you plan to run.

## Create a Virtual Hard Disk
1. Select "Create a virtual hard disk now" and click "Create".
2. Choose the hard disk file type (the default, VDI, is usually fine).
3. Choose whether the disk should be dynamically allocated (grows as needed) or fixed size (pre-allocated).
4. Allocate the desired amount of disk space.

## Configure Virtual Machine Settings
1. Configure additional settings for your VM as needed (e.g., network, storage, etc.).

## Install Operating System
1. Start the VM by selecting it from the VirtualBox Manager and clicking "Start".
2. Follow the prompts to install the operating system from the ISO file.

## Install Virtual Machine Additions/Tools
1. Install necessary tools and additions, such as Docker.
   - Follow the guide to [install and configure Docker](https://devopscube.com/how-to-install-and-configure-docker/).

## How to Run a Docker Image from Docker Hub in a Linux Environment
1. Run the terminal in Linux.
2. Connect to Docker Hub in the browser.
3. Docker login if needed.
4. In terminal:
   ```sh
   docker pull yourRepo/imagename
5. Use the command docker images to list your images.
6. Use the Image ID to run the image in the Linux environment.
