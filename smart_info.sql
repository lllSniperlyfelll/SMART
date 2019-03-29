-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 29, 2019 at 05:19 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smart_info`
--

-- --------------------------------------------------------

--
-- Table structure for table `diseases`
--

CREATE TABLE `diseases` (
  `diseases` varchar(5000) NOT NULL,
  `info` varchar(5000) NOT NULL,
  `precaution` varchar(5000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diseases`
--

INSERT INTO `diseases` (`diseases`, `info`, `precaution`) VALUES
('Malaria', '<p>\r\n<b>About Malaria</b><br>\r\nMalaria is a serious tropical disease spread by mosquitoes. If it isn\'t diagnosed and treated promptly, it can be fatal.\r\nA single mosquito bite is all it takes for someone to become infected.\r\n</p>\r\n<p>\r\n<b>What causes malaria?</b><br>\r\nMalaria is caused by a type of parasite known as Plasmodium. There are many different types of Plasmodia parasites, but only five cause malaria in humans.\r\nThe Plasmodium parasite is mainly spread by female Anopheles mosquitoes, which mainly bite at dusk and at night. When an infected mosquito bites a human, it passes the parasites into the bloodstream.\r\nMalaria can also be spread through blood transfusions and the sharing of needles, but this is very rare.\r\n</p>', '<p>\r\n<b>Preventing malaria</b><br>	\r\nMany cases of malaria can be avoided. An easy way to remember is the ABCD approach to prevention:\r\n<ul>\r\n<li>Awareness of risk – find out whether you\'re at risk of getting malaria before travelling</li>\r\n<li>Bite prevention – avoid mosquito bites by using insect repellent, covering your arms and legs, and using an insecticide-treated mosquito net</li>\r\n<li>Check whether you need to take malaria prevention tablets – if you do, make sure you take the right antimalarial tablets at the right dose, and finish the course</li>\r\n<li>Diagnosis – seek immediate medical advice if you develop malaria symptoms, as long as up to a year after you return from travelling</li>\r\n</ul>\r\nSpeak to your GP if you\'re planning to visit an area where there\'s a malaria risk. It may be recommended that you take antimalarial tablets to prevent infection.\r\n</p>'),
('Chickenpox', '<p>\r\n<b>About Chickenpox</b><br>\r\nChickenpox is a mild and common childhood illness that most children catch at some point.\r\nIt causes a rash of red, itchy spots that turn into fluid-filled blisters. They then crust over to form scabs, which eventually drop off.\r\nSome children have only a few spots, but other children can have spots that cover their entire body. These are most likely to appear on the face, ears and scalp, under the arms, on the chest and belly, and on the arms and legs. \r\nChickenpox (known medically as varicella) is caused by a virus called the varicella-zoster virus. It\'s spread quickly and easily from someone who is infected. \r\nChickenpox is most common in children under the age of 10. In fact, chickenpox is so common in childhood that over 90% of adults are immune to the condition because they\'ve had it before.\r\nChildren usually catch chickenpox in winter and spring, particularly between March and May.\r\n</p>\r\n<p>\r\n<b>What to do</b><br>\r\nTo prevent spreading the infection, keep children off nursery or school until all their spots have crusted over.\r\nChickenpox is infectious from 1 to 2 days before the rash starts, until all the blisters have crusted over (usually 5 to 6 days after the start of the rash).\r\nIf your child has chickenpox, try to keep them away from public areas to avoid contact with people who may not have had it, especially people who are at risk of serious problems, such as new born babies, pregnant women and anyone with a weakened immune system (for example, people having cancer treatment or taking steroid tablets). \r\n</p>', '<p>\r\n<b>Chickenpox treatment</b><br>\r\nChickenpox in children is considered a mild illness, but your child will probably feel pretty miserable and irritable while they have it.\r\nYour child may have a fever for the first few days of the illness. The spots can be incredibly itchy.\r\nThere is no specific treatment for chickenpox, but there are pharmacy remedies that can alleviate symptoms. These include paracetamol to relieve fever, and calamine lotion and cooling gels to ease itching.\r\nIn most children, the blisters crust up and fall off naturally within one to two weeks.\r\n</p>'),
('Common Cold', '<p>\r\n<b>About Common Cold</b><br>\r\nA cold is a mild viral infection of the nose, throat, sinuses and upper airways. It\'s very common and usually clears up on its own within a week or two.</p>\r\n<p>\r\n<b>What to do</b><br>\r\nThere\'s no cure for a cold, but you can look after yourself at home by:\r\n<ul>\r\n<li>resting, drinking plenty of fluids and eating healthily</li>\r\n<li>taking over-the-counter painkillers, such as paracetamol or ibuprofen, to reduce any fever or discomfort</li>\r\n<li>using decongestant sprays or tablets to relieve a blocked nose</li>\r\n<li>trying remedies such as gargling salt water and sucking on menthol sweets</li>\r\n</ul>\r\nMany painkillers and decongestants are available from pharmacies without a prescription. They\'re generally safe for older children and adults to take, but might not be suitable for babies, young children, pregnant women, people with certain underlying health conditions, and those taking certain other medications. Speak to a pharmacist if you\'re unsure.\r\n</p>', '<p>\r\n<b>Treating a common cold</b><br>\r\nYou can manage cold symptoms yourself by following some simple advice. You\'ll normally start to feel better within 7 to 10 days.\r\n<b>General advice<b>\r\nUntil you\'re feeling better, it may help to:\r\n<ul>\r\n<li>drink plenty of fluids to replace those lost from sweating and having a runny nose</li>\r\n<li>eat healthily – a low-fat, high-fibre diet is recommended, including plenty of fresh fruit and vegetables</li>\r\n</ul>\r\nYou may lose your appetite when you have a cold. This is perfectly normal and should only last a few days. Don\'t force yourself to eat if you\'re not feeling hungry.\r\nYou may also wish to try some of the medications and remedies described below to help relieve your symptoms.\r\n<p><b>Other remedies</b><br>\r\nThe remedies outlined below may also help relieve your symptoms.\r\nGargling and menthol sweets\r\nSome people find gargling with salt water and sucking on menthol sweets can help relieve a sore throat and blocked nose.\r\n<br><b>Vapour rubs</b><br>\r\nVapour rubs can help babies and young children breathe more easily when they have a cold. Apply the rub to your child\'s chest and back. Don\'t apply it to their nostrils because this could cause irritation and breathing difficulties.\r\n<b>Nasal saline drops</b><br>\r\nNasal saline (salt water) drops can help relieve a blocked nose in babies and young children.\r\n<b>Vitamin and mineral supplements</b><br>\r\nThere is some evidence to suggest that taking zinc supplements within a day of the symptoms starting will speed up recovery from a cold and reduce the severity of symptoms.\r\nHowever, there is currently little evidence to suggest that taking vitamin C supplements is beneficial when a cold start.\r\n</p>');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
